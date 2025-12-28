package com.ismaildrs.conferenceservice.services;

import com.ismaildrs.conferenceservice.clients.KeynoteRestClient;
import com.ismaildrs.conferenceservice.dtos.ConferenceDTO;
import com.ismaildrs.conferenceservice.entities.Conference;
import com.ismaildrs.conferenceservice.mappers.ConferenceMapper;
import com.ismaildrs.conferenceservice.models.Keynote;
import com.ismaildrs.conferenceservice.repositories.ConferenceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ConferenceServiceImpl implements ConferenceService {

  private ConferenceRepository conferenceRepository;
  private ConferenceMapper conferenceMapper;
  private KeynoteRestClient keynoteRestClient;

  @Override
  public ConferenceDTO saveConference(ConferenceDTO conferenceDTO) {
    Conference conference = conferenceMapper.fromConferenceDTO(conferenceDTO);
    Conference savedConference = conferenceRepository.save(conference);
    return conferenceMapper.fromConference(savedConference);
  }

  @Override
  public ConferenceDTO getConference(Long id) {
    Conference conference = conferenceRepository.findById(id).orElse(null);
    if (conference == null)
      return null;
    ConferenceDTO dto = conferenceMapper.fromConference(conference);
    // Enrich with Keynote details
    if (conference.getKeynoteId() != null) {
      try {
        Keynote keynote = keynoteRestClient.getKeynoteById(conference.getKeynoteId());
        dto.setKeynote(keynote);
      } catch (Exception e) {
        log.error("Error fetching Keynote with ID " + conference.getKeynoteId(), e);
      }
    }
    return dto;
  }

  @Override
  public List<ConferenceDTO> getAllConferences() {
    return conferenceRepository.findAll().stream()
        .map(conference -> {
          ConferenceDTO dto = conferenceMapper.fromConference(conference);
          if (conference.getKeynoteId() != null) {
            try {
              Keynote keynote = keynoteRestClient.getKeynoteById(conference.getKeynoteId());
              dto.setKeynote(keynote);
            } catch (Exception e) {
              log.error("Error fetching Keynote with ID " + conference.getKeynoteId(), e);
            }
          }
          return dto;
        })
        .collect(Collectors.toList());
  }
}

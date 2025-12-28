package com.ismaildrs.conferenceservice.services;

import com.ismaildrs.conferenceservice.dtos.ConferenceDTO;
import java.util.List;

public interface ConferenceService {
  ConferenceDTO saveConference(ConferenceDTO conferenceDTO);

  ConferenceDTO getConference(Long id);

  List<ConferenceDTO> getAllConferences();
}

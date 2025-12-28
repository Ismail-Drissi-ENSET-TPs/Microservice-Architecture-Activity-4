package com.ismaildrs.keynoteservice.services;

import com.ismaildrs.keynoteservice.dtos.KeynoteDTO;
import com.ismaildrs.keynoteservice.entities.Keynote;
import com.ismaildrs.keynoteservice.mappers.KeynoteMapper;
import com.ismaildrs.keynoteservice.repositories.KeynoteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

  private KeynoteRepository keynoteRepository;
  private KeynoteMapper keynoteMapper;

  @Override
  public KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO) {
    Keynote keynote = keynoteMapper.fromKeynoteDTO(keynoteDTO);
    Keynote savedKeynote = keynoteRepository.save(keynote);
    return keynoteMapper.fromKeynote(savedKeynote);
  }

  @Override
  public KeynoteDTO getKeynote(Long id) {
    Keynote keynote = keynoteRepository.findById(id).orElse(null);
    return keynoteMapper.fromKeynote(keynote);
  }

  @Override
  public List<KeynoteDTO> getAllKeynotes() {
    return keynoteRepository.findAll().stream()
        .map(keynoteMapper::fromKeynote)
        .collect(Collectors.toList());
  }

  @Override
  public KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO) {
    if (!keynoteRepository.existsById(id))
      return null;
    Keynote keynote = keynoteMapper.fromKeynoteDTO(keynoteDTO);
    keynote.setId(id);
    Keynote savedKeynote = keynoteRepository.save(keynote);
    return keynoteMapper.fromKeynote(savedKeynote);
  }

  @Override
  public void deleteKeynote(Long id) {
    keynoteRepository.deleteById(id);
  }
}

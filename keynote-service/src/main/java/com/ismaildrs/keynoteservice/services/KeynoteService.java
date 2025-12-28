package com.ismaildrs.keynoteservice.services;

import com.ismaildrs.keynoteservice.dtos.KeynoteDTO;
import java.util.List;

public interface KeynoteService {
  KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO);

  KeynoteDTO getKeynote(Long id);

  List<KeynoteDTO> getAllKeynotes();

  KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO);

  void deleteKeynote(Long id);
}

package com.ismaildrs.keynoteservice.mappers;

import com.ismaildrs.keynoteservice.dtos.KeynoteDTO;
import com.ismaildrs.keynoteservice.entities.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

  public KeynoteDTO fromKeynote(Keynote keynote) {
    if (keynote == null)
      return null;
    return KeynoteDTO.builder()
        .id(keynote.getId())
        .nom(keynote.getNom())
        .prenom(keynote.getPrenom())
        .email(keynote.getEmail())
        .fonction(keynote.getFonction())
        .build();
  }

  public Keynote fromKeynoteDTO(KeynoteDTO keynoteDTO) {
    if (keynoteDTO == null)
      return null;
    return Keynote.builder()
        .id(keynoteDTO.getId())
        .nom(keynoteDTO.getNom())
        .prenom(keynoteDTO.getPrenom())
        .email(keynoteDTO.getEmail())
        .fonction(keynoteDTO.getFonction())
        .build();
  }
}

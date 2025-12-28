package com.ismaildrs.conferenceservice.web;

import com.ismaildrs.conferenceservice.dtos.ConferenceDTO;
import com.ismaildrs.conferenceservice.services.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@AllArgsConstructor
public class ConferenceController {

  private ConferenceService conferenceService;

  @GetMapping
  public List<ConferenceDTO> getAllConferences() {
    return conferenceService.getAllConferences();
  }

  @GetMapping("/{id}")
  public ConferenceDTO getConference(@PathVariable Long id) {
    return conferenceService.getConference(id);
  }

  @PostMapping
  public ConferenceDTO saveConference(@RequestBody ConferenceDTO conferenceDTO) {
    return conferenceService.saveConference(conferenceDTO);
  }
}

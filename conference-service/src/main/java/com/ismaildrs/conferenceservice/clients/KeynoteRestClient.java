package com.ismaildrs.conferenceservice.clients;

import com.ismaildrs.conferenceservice.models.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service", url = "http://localhost:8081") // Normally URL is not needed with Registry, but
                                                                      // for local tests. With Eureka use name.
public interface KeynoteRestClient {
  @GetMapping("/api/keynotes/{id}")
  Keynote getKeynoteById(@PathVariable("id") Long id);
}

package com.ismaildrs.conferenceservice.mappers;

import com.ismaildrs.conferenceservice.dtos.ConferenceDTO;
import com.ismaildrs.conferenceservice.dtos.ReviewDTO;
import com.ismaildrs.conferenceservice.entities.Conference;
import com.ismaildrs.conferenceservice.entities.Review;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ConferenceMapper {

  public ReviewDTO fromReview(Review review) {
    if (review == null)
      return null;
    return ReviewDTO.builder()
        .id(review.getId())
        .date(review.getDate())
        .texte(review.getTexte())
        .stars(review.getStars())
        .build();
  }

  public ConferenceDTO fromConference(Conference conference) {
    if (conference == null)
      return null;
    ConferenceDTO dto = ConferenceDTO.builder()
        .id(conference.getId())
        .titre(conference.getTitre())
        .type(conference.getType())
        .date(conference.getDate())
        .duree(conference.getDuree())
        .nombreInscrits(conference.getNombreInscrits())
        .score(conference.getScore())
        .keynoteId(conference.getKeynoteId())
        .build();

    if (conference.getReviews() != null) {
      dto.setReviews(conference.getReviews().stream()
          .map(this::fromReview)
          .collect(Collectors.toList()));
    }
    return dto;
  }

  public Conference fromConferenceDTO(ConferenceDTO conferenceDTO) {
    if (conferenceDTO == null)
      return null;
    return Conference.builder()
        .id(conferenceDTO.getId())
        .titre(conferenceDTO.getTitre())
        .type(conferenceDTO.getType())
        .date(conferenceDTO.getDate())
        .duree(conferenceDTO.getDuree())
        .nombreInscrits(conferenceDTO.getNombreInscrits())
        .score(conferenceDTO.getScore())
        .keynoteId(conferenceDTO.getKeynoteId())
        .build();
  }
}

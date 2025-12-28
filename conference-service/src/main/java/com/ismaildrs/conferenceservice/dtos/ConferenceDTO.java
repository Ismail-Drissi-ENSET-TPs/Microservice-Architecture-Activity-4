package com.ismaildrs.conferenceservice.dtos;

import com.ismaildrs.conferenceservice.models.Keynote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceDTO {
  private Long id;
  private String titre;
  private String type;
  private Date date;
  private double duree;
  private int nombreInscrits;
  private double score;
  private Long keynoteId;
  private Keynote keynote;
  private Collection<ReviewDTO> reviews;
}

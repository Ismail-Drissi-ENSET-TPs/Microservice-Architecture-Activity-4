package com.ismaildrs.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titre;
  private String type; // académique ou commerciale
  private Date date;
  private double duree;
  private int nombreInscrits;
  private double score;

  @OneToMany(mappedBy = "conference")
  private Collection<Review> reviews;
}

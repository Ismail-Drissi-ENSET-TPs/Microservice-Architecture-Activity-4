package com.ismaildrs.keynoteservice.repositories;

import com.ismaildrs.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}

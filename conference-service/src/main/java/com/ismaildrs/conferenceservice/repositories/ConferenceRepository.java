package com.ismaildrs.conferenceservice.repositories;

import com.ismaildrs.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}

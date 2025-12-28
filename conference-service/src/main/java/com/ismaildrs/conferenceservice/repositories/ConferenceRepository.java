package com.ismaildrs.conferenceservice.repositories;

import com.ismaildrs.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}

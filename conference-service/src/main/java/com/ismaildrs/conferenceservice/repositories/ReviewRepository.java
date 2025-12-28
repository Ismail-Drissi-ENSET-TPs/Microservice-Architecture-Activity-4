package com.ismaildrs.conferenceservice.repositories;

import com.ismaildrs.conferenceservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

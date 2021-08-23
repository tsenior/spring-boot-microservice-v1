package com.tinyiko.exploresoweto.repositories;

import com.tinyiko.exploresoweto.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {
}

package com.synchrony.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synchrony.main.entities.Images;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
	
}


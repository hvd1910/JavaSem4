package com.example.guide.repository;

import com.example.guide.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPlaceId(Long placeId);
}


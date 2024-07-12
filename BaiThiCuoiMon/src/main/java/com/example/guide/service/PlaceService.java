package com.example.guide.service;

import com.example.guide.Response.PlaceResponse;
import com.example.guide.entity.Place;
import com.example.guide.entity.Image;
import com.example.guide.repository.ImageRepository;
import com.example.guide.repository.PlaceRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    @Transactional(readOnly = true)
    public Place getPlaceById(Long id) {
        return placeRepository.findByIdWithImages(id).orElse(null);
    }

    @Transactional
    public Place updatePlace(Long id, Place placeDetails) {
        Place place = getPlaceById(id);
        if (place != null) {
            place.setName(placeDetails.getName());
            place.setDescription(placeDetails.getDescription());
            place.setLocation(placeDetails.getLocation());
            place.setDescription(placeDetails.getContent());
            return placeRepository.save(place);
        }
        return null; // or throw exception if needed
    }

    @Transactional
    public void deletePlace(Long id) {
        Place place = getPlaceById(id);
        if (place != null) {
            placeRepository.delete(place);
        }
    }

    @Transactional
    public void addImagesToPlace(Long placeId, List<Image> images) {
        Place place = getPlaceById(placeId);
        if (place != null) {

            for (Image image : images) {
                Image newImage = new Image();
                newImage.setPlace(place);
                newImage.setUrl(image.getUrl());
                imageRepository.save(newImage);
            }

        }
    }

    public List<PlaceResponse> getAllPlaces() {
        List<Place>placeList = placeRepository.findAll();
        return placeList.stream()
                .map(PlaceResponse::fromPlace)
                .collect(Collectors.toList());
    }


    @Transactional
    public void batchProcessPlaces(List<Place> places) {
        entityManager.getTransaction().begin();
        for (int i = 0; i < places.size(); i++) {
            entityManager.persist(places.get(i));
            if (i % 50 == 0) { // Batch size
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.getTransaction().commit();
    }

    @Transactional(readOnly = true)
    public Page<Place> searchPlaces(String keyword, Pageable pageable) {
        return placeRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword, pageable);
    }


}

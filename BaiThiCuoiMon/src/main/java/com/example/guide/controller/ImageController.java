package com.example.guide.controller;

import com.example.guide.DTO.ImageDTO;
import com.example.guide.entity.Image;
import com.example.guide.entity.Place;
import com.example.guide.repository.PlaceRepository;
import com.example.guide.service.ImageService;
import com.example.guide.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private PlaceRepository placeRepository;

    @PostMapping("/{idPlace}")
    public ResponseEntity<Image> createImage(@PathVariable("idPlace") Long id,
                                             @RequestBody ImageDTO imageDTO) {


        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Image ImageInput = new Image();
        ImageInput.setUrl(imageDTO.getUrl());
        ImageInput.setPlace(place.get());
        Image createdImage = imageService.createImage(ImageInput);
        return new ResponseEntity<>(createdImage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        if (image != null) {
            return new ResponseEntity<>(image, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image imageDetails) {
        Image updatedImage = imageService.updateImage(id, imageDetails);
        if (updatedImage != null) {
            return new ResponseEntity<>(updatedImage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        if (image != null) {
            imageService.deleteImage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}


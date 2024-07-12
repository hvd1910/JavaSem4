package com.example.guide.service;

import com.example.guide.entity.Image;
import com.example.guide.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Transactional(readOnly = true)
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Transactional
    public Image updateImage(Long id, Image imageDetails) {
        Image image = getImageById(id);
        if (image != null) {
            image.setUrl(imageDetails.getUrl());
            return imageRepository.save(image);
        }
        return null;
    }

    @Transactional
    public void deleteImage(Long id) {
        Image image = getImageById(id);
        if (image != null) {
            imageRepository.delete(image);
        }
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Image> getImagesByPlaceId(Long placeId) {
        return imageRepository.findByPlaceId(placeId);
    }
}

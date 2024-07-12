package com.example.guide.controller;

import com.example.guide.DTO.CommentDTO;
import com.example.guide.DTO.PlaceRequestDTO;
import com.example.guide.Response.PlaceResponse;
import com.example.guide.entity.Comment;
import com.example.guide.entity.Place;
import com.example.guide.entity.Image;
import com.example.guide.entity.User;
import com.example.guide.repository.UserRepository;
import com.example.guide.service.CommentService;
import com.example.guide.service.ImageService;
import com.example.guide.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<Place> createPlace(@RequestBody PlaceRequestDTO placeRequestDTO) {

        Optional<User> user = userRepository.findById(placeRequestDTO.getCreatedBy());
        if(user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Place place = new Place();
        place.setName(placeRequestDTO.getName());
        place.setDescription(placeRequestDTO.getDescription());
        place.setLocation(placeRequestDTO.getLocation());
        place.setContent(placeRequestDTO.getContent());
        place.setUserId(user.get());

        List<Image> images = placeRequestDTO.getImages();
        if (images != null && !images.isEmpty()) {
            for (Image image : images) {
                image.setPlace(place);
            }
            place.setImages(images);
        }

        Place createdPlace = placeService.createPlace(place);
        return new ResponseEntity<>(createdPlace, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        Place place = placeService.getPlaceById(id);
        if (place != null) {
            return new ResponseEntity<>(place, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        Place updatedPlace = placeService.updatePlace(id, placeDetails);
        if (updatedPlace != null) {
            return new ResponseEntity<>(updatedPlace, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        Place place = placeService.getPlaceById(id);
        if (place != null) {
            placeService.deletePlace(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{placeId}/images")
    public ResponseEntity<Void> addImagesToPlace(@PathVariable Long placeId, @RequestBody List<Image> images) {
        placeService.addImagesToPlace(placeId, images);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("")
    public ResponseEntity<List<PlaceResponse>> getAllPlaces() {
        List<PlaceResponse> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Place>> searchPlaces(@RequestParam String keyword, Pageable pageable) {
        Page<Place> places = placeService.searchPlaces(keyword, pageable);
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @Autowired
    private CommentService commentService;

    @PostMapping("/{placeId}/comments")
    public ResponseEntity<Comment> addCommentToPlace(@PathVariable Long placeId, @RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setRating(commentDTO.getRating());



        Comment createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @Autowired
    private ImageService imageService; // Đảm bảo đã inject ImageService

    // Các phương thức hiện có đã được bỏ qua để tập trung vào thêm chức năng mới

    @GetMapping("/{placeId}/images")
    public ResponseEntity<List<Image>> getImagesByPlaceId(@PathVariable Long placeId) {
        List<Image> images = imageService.getImagesByPlaceId(placeId);
        if (images != null && !images.isEmpty()) {
            return new ResponseEntity<>(images, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}


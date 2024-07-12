package com.example.guide.controller;

import com.example.guide.DTO.CommentDTO;
import com.example.guide.entity.Comment;
import com.example.guide.entity.Place;
import com.example.guide.service.CommentService;
import com.example.guide.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PlaceService placeService;

    @PostMapping("/add/{placeId}")
    public ResponseEntity<Comment> createCommentForPlace(@PathVariable Long placeId, @RequestBody CommentDTO commentDTO) {
        Place place = placeService.getPlaceById(placeId);
        if (place == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setRating(commentDTO.getRating());
        comment.setPlace(place);

        Comment createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        Comment existingComment = commentService.getCommentById(id);
        if (existingComment != null) {
            existingComment.setComment(commentDTO.getComment());
            existingComment.setRating(commentDTO.getRating());

            Comment updatedComment = commentService.updateComment(id, existingComment);
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            commentService.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Comment>> getAllCommentsForPlace(@PathVariable Long placeId) {
        Place place = placeService.getPlaceById(placeId);
        if (place == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Comment> comments = commentService.getAllCommentsForPlace(place);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}

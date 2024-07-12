package com.example.guide.service;

import com.example.guide.entity.Comment;
import com.example.guide.entity.Place;
import com.example.guide.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);
        if (comment != null) {
            comment.setComment(commentDetails.getComment());
            comment.setRating(commentDetails.getRating());
            // Cập nhật các trường khác nếu cần thiết
            return commentRepository.save(comment);
        }
        return null;
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Comment> getAllCommentsForPlace(Place place) {
        return commentRepository.findByPlace(place);
    }
}

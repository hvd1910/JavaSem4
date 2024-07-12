package com.example.guide.repository;

import com.example.guide.entity.Comment;
import com.example.guide.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPlace(Place place);
}


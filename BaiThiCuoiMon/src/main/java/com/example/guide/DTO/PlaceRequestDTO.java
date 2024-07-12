package com.example.guide.DTO;

import com.example.guide.entity.Comment;
import com.example.guide.entity.Image;
import com.example.guide.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

public class PlaceRequestDTO {
    private String name;
    @Lob
    private String description;
    private String location;

    @Lob
    private  String content;
    private Long createdBy;


    private List<Image> images;


    private List<Comment> comments;

    public PlaceRequestDTO(String name, String description, String location, String content, Long createdBy, List<Image> images, List<Comment> comments) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.content = content;
        this.createdBy = createdBy;
        this.images = images;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PlaceRequestDTO() {
    }


}

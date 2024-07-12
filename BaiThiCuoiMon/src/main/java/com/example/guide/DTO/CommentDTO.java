package com.example.guide.DTO;

public class CommentDTO {

    private Long placeId;
    private String comment;
    private int rating;

    // Getters and Setters
    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CommentDTO(Long userId, String comment, int rating) {}
    public CommentDTO( String comment, int rating, Long placeId) {
        this.comment = comment;
        this.rating = rating;
        this.placeId = placeId;
    }
    public CommentDTO() {}
}
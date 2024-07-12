package com.example.guide.Response;


import com.example.guide.entity.Image;
import com.example.guide.entity.Place;
import com.example.guide.entity.User;
import lombok.*;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceResponse {

    private Long id;

    private String name;
    private String description;
    private String location;

    private String content;


    private Long userId;


    private List<Image> images;




    public static  PlaceResponse fromPlace(Place place) {

        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .location(place.getLocation())
                .content(place.getContent())
                .userId(place.getUserId().getId())
                .images(place.getImages())
                .build();
    }

}

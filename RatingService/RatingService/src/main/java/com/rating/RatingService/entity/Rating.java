package com.rating.RatingService.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating {

    @Id
    private String rattingId;
    private String userId;
    private String hotelId;
    private int ratting;
    private String feedback;

    private Hotel hotel;
}





















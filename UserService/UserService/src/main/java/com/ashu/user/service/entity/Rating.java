package com.ashu.user.service.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String rattingId;
    private String userId;
    private String hotelId;
    private int ratting;
    private String feedback;

    private Hotel hotel;

}

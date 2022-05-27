package com.aasihyaana.aashiyaanabackend.dto;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer id;
    private String title;
    private String description;
    private RoomType roomType;
    private Double price;
    private Double stars;
    private Integer reviews;
    private String image_url;
}

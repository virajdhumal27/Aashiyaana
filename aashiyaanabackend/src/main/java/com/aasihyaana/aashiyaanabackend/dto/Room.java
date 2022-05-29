package com.aasihyaana.aashiyaanabackend.dto;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code Room} class contains data of Living Rooms, Bedrooms and Kitchen that needs to be sent to frontend.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
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

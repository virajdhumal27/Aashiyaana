package com.aasihyaana.aashiyaanabackend.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    private Integer room_id;
    private String room_title;
    private String description;
    private Double price;
    private Double stars;
    private Integer reviews;
    private String image_url;
}

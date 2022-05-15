package com.aasihyaana.aashiyaanabackend.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class RoomEntity {
    @Id
    private Integer room_id;
    private String room_title;
    private String description;
    private Double price;
    private Double stars;
    private Integer reviews;
    private String image_url;
}

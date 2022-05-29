package com.aasihyaana.aashiyaanabackend.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code RoomEntity} class describes the columns of table {@code rooms}.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class RoomEntity {
    @Id
    private Integer room_id;
    @Column(name ="room_title")
    private String roomTitle;
    private String description;
    @Column(name = "room_type")
    private RoomType roomType;
    private Double price;
    private Double stars;
    private Integer reviews;
    @Column(name = "image_url")
    private String imageUrl;
}

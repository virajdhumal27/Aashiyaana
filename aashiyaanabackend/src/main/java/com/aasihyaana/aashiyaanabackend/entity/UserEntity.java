package com.aasihyaana.aashiyaanabackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code UserEntity} class describes the columns of table {@code users}.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    private String username;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String password;
}

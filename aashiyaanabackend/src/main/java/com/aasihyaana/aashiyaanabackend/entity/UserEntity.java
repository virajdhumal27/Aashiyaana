package com.aasihyaana.aashiyaanabackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
}

package com.aasihyaana.aashiyaanabackend.repositories;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByUsername(String username);

}

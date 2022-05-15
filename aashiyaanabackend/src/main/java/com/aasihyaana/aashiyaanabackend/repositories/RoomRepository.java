package com.aasihyaana.aashiyaanabackend.repositories;

import com.aasihyaana.aashiyaanabackend.entity.RoomEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long>{
    
}

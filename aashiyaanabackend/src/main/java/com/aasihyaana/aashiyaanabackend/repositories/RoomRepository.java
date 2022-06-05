package com.aasihyaana.aashiyaanabackend.repositories;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;
import com.aasihyaana.aashiyaanabackend.entity.RoomEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    List<RoomEntity> findByRoomType(RoomType roomType);

}

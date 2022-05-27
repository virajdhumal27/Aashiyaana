package com.aasihyaana.aashiyaanabackend.repositoryservices;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;

public interface RoomsRepositoryService {
    List<Room> findAllLivingRoomsList();
    List<Room> findAllBedRoomsList();
}
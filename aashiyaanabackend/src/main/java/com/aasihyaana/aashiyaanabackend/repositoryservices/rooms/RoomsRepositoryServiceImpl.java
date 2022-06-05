package com.aasihyaana.aashiyaanabackend.repositoryservices.rooms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;
import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.entity.RoomEntity;
import com.aasihyaana.aashiyaanabackend.repositories.RoomRepository;

@Service
public class RoomsRepositoryServiceImpl implements RoomsRepositoryService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAllLivingRoomsList() {
        List<RoomEntity> roomEntities = roomRepository.findByRoomType(RoomType.LIVING_ROOM);

        List<Room> livingRooms = roomHelperList(roomEntities);
        return livingRooms;
    }

    @Override
    public List<Room> findAllBedRoomsList() {
        List<RoomEntity> roomEntities = roomRepository.findByRoomType(RoomType.BEDROOM);
        List<Room> bedrooms = roomHelperList(roomEntities);
        return bedrooms;
    }

    @Override
    public List<Room> findAllKitchensList() {
        List<RoomEntity> roomEntities = roomRepository.findByRoomType(RoomType.KITCHEN);
        List<Room> kitchens = roomHelperList(roomEntities);
        return kitchens;
    }

    private List<Room> roomHelperList(List<RoomEntity> roomEntities) {
        List<Room> rooms = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            Room room = new Room();
            room.setId(roomEntity.getRoomId());
            room.setTitle(roomEntity.getRoomTitle());
            room.setImage_url(roomEntity.getImageUrl());
            room.setPrice(roomEntity.getPrice());
            room.setReviews(roomEntity.getReviews());
            room.setRoomType(roomEntity.getRoomType());
            room.setStars(roomEntity.getStars());

            rooms.add(room);
        }
        return rooms;
    }
    
}

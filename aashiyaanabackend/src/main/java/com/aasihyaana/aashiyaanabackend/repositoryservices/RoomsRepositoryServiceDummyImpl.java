package com.aasihyaana.aashiyaanabackend.repositoryservices;

import java.util.ArrayList;
import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.entity.RoomEntity;
import com.aasihyaana.aashiyaanabackend.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsRepositoryServiceDummyImpl implements RoomsRepositoryService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAllLivingRoomsList() {
        List<RoomEntity> roomEntities = roomRepository.findAll();

        List<Room> roomList = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            roomList.add(convertToRoom(roomEntity));
        }
        return roomList;
    }

    private Room convertToRoom(RoomEntity roomEntity) {
        Room room = new Room();
        room.setId(roomEntity.getRoom_id());
        room.setTitle(roomEntity.getRoom_title());
        room.setDescription(roomEntity.getDescription());
        room.setPrice(roomEntity.getPrice());
        room.setStars(roomEntity.getStars());
        room.setReviews(roomEntity.getReviews());
        room.setImage_url(roomEntity.getImage_url());
        
        return room;
    }
    
}

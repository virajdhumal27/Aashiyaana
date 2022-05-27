package com.aasihyaana.aashiyaanabackend.repositoryservices;

import java.util.ArrayList;
import java.util.List;

import com.aasihyaana.aashiyaanabackend.constants.RoomType;
import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.entity.RoomEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomsRepositoryServiceDummyImpl implements RoomsRepositoryService {

    @Override
    public List<Room> findAllLivingRoomsList() {
        List<RoomEntity> roomEntities = loadSampleRoomData();

        List<Room> roomList = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            roomList.add(convertToRoom(roomEntity));
        }
        return roomList;
    }

    private Room convertToRoom(RoomEntity roomEntity) {
        Room room = new Room();
        room.setId(roomEntity.getRoom_id());
        room.setTitle(roomEntity.getRoomTitle());
        room.setDescription(roomEntity.getDescription());
        room.setRoomType(roomEntity.getRoomType());
        room.setPrice(roomEntity.getPrice());
        room.setStars(roomEntity.getStars());
        room.setReviews(roomEntity.getReviews());
        room.setImage_url(roomEntity.getImageUrl());

        return room;
    }

    @Override
    public List<Room> findAllBedRoomsList() {
        return null;
    }

    private List<RoomEntity> loadSampleRoomData() {

        List<RoomEntity> roomEntities = new ArrayList<>();

        for (int i = 1; i < 31; i++) {
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomTitle("Title" + i);
            roomEntity.setDescription("Description4" + i);
            roomEntity.setRoom_id(i);
            if (i % 3 == 0) {
                roomEntity.setRoomType(RoomType.BEDROOM);
            } else if (i % 5 == 0) {
                roomEntity.setRoomType(RoomType.KITCHEN);
            } else {
                roomEntity.setRoomType(RoomType.LIVING_ROOM);
            }
            roomEntity.setPrice(100.00 * i);
            roomEntity.setStars(4.5);
            roomEntity.setReviews(100 * i);
            roomEntity.setImageUrl("URL" + i);

            roomEntities.add(roomEntity);
        }

        return roomEntities;
    }

}

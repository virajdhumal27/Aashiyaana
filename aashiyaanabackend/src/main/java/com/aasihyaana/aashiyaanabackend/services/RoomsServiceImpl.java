package com.aasihyaana.aashiyaanabackend.services;

import java.util.ArrayList;
import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;

import org.springframework.stereotype.Service;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Override
    public GetRoomsResponse getLivingRoomData() {
        List<Room> rooms = new ArrayList<>();
        
        Room room = new Room();
        room.setId(1);
        room.setTitle("Title");
        room.setDescription("Description");
        room.setPrice(200.00);
        room.setStars(5.0);
        room.setReviews(1);
        room.setImage_url("URL");
        rooms.add(room);
        
        GetRoomsResponse response = new GetRoomsResponse(rooms);
        return response;
    }
    
}

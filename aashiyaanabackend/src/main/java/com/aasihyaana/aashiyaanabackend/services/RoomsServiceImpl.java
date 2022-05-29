package com.aasihyaana.aashiyaanabackend.services;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;
import com.aasihyaana.aashiyaanabackend.repositoryservices.RoomsRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepositoryService roomsRepositoryService;

    @Override
    public GetRoomsResponse getLivingRoomData() {

        // if (ActiveUsers.checkUserActive(1)) {
        //     return new GetRoomsResponse(Boolean.FALSE, null);
        // }
        List<Room> rooms = roomsRepositoryService.findAllLivingRoomsList();
        
        GetRoomsResponse response = new GetRoomsResponse(Boolean.TRUE, rooms);
        return response;
    }

    @Override
    public GetRoomsResponse getBedRoomData() {

        List<Room> rooms = roomsRepositoryService.findAllBedRoomsList();
        return new GetRoomsResponse(Boolean.TRUE, rooms);
    }
    
}

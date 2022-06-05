package com.aasihyaana.aashiyaanabackend.services.roomsservice;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.constants.ActiveUsers;
import com.aasihyaana.aashiyaanabackend.dto.Room;
import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;
import com.aasihyaana.aashiyaanabackend.repositoryservices.rooms.RoomsRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepositoryService roomsRepositoryService;

    @Override
    public GetRoomsResponse getLivingRoomData(Integer userId) {

        if (!ActiveUsers.checkUserActive(userId)) {
            return new GetRoomsResponse(Boolean.FALSE, null);
        }
        
        List<Room> rooms = roomsRepositoryService.findAllLivingRoomsList();
        
        GetRoomsResponse response = new GetRoomsResponse(Boolean.TRUE, rooms);
        return response;
    }

    @Override
    public GetRoomsResponse getBedRoomData(Integer userId) {

        if (!ActiveUsers.checkUserActive(userId)) {
            return new GetRoomsResponse(Boolean.FALSE, null);
        }

        List<Room> rooms = roomsRepositoryService.findAllBedRoomsList();
        return new GetRoomsResponse(Boolean.TRUE, rooms);
    }

    @Override
    public GetRoomsResponse getKitchensData(Integer userId) {

        if (!ActiveUsers.checkUserActive(userId)) {
            return new GetRoomsResponse(Boolean.FALSE, null);
        }

        List<Room> rooms = roomsRepositoryService.findAllKitchensList();
        return new GetRoomsResponse(Boolean.TRUE, rooms);
    }
    
}

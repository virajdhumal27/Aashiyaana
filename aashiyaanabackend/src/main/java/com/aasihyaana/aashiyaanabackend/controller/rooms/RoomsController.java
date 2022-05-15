package com.aasihyaana.aashiyaanabackend.controller.rooms;

import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;
import com.aasihyaana.aashiyaanabackend.services.RoomsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoomsController.ROOM_ENDPOINT)
public class RoomsController {
    
    public static final String ROOM_ENDPOINT = "/rooms";
    public static final String GETROOM_ENDPOINT = "/livingrooms";

    @Autowired
    RoomsService roomsService;

    @GetMapping(GETROOM_ENDPOINT)
    public GetRoomsResponse getLivingRoomData() {
        return roomsService.getLivingRoomData();
    }
}

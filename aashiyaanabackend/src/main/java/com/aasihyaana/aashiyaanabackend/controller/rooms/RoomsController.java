package com.aasihyaana.aashiyaanabackend.controller.rooms;

import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;
import com.aasihyaana.aashiyaanabackend.services.roomsservice.RoomsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code RoomsController} class handles the request related to living rooms, 
 * bedrooms and kitchen. Once request is processed, required data is sent back
 * in form of {@code GetRoomsResponse}.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@RestController
// @CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:9191"})
@CrossOrigin(origins = "*")
@RequestMapping(RoomsController.ROOM_ENDPOINT)
public class RoomsController {
    
    public static final String ROOM_ENDPOINT = "/rooms";
    public static final String LIVING_ROOM_API = "/livingrooms/users/{userId}";
    public static final String BEDROOM_API = "/bedrooms/users/{userId}";
    public static final String KITCHEN_API = "/kitchens/users/{userId}";

    @Autowired
    private RoomsService roomsService;

    @GetMapping(LIVING_ROOM_API)
    public GetRoomsResponse getLivingRoomData(@PathVariable Integer userId) {
        System.out.println(userId);
        return roomsService.getLivingRoomData(userId);
    }

    @GetMapping(BEDROOM_API)
    public GetRoomsResponse getBedRoomData(@PathVariable Integer userId) {
        return roomsService.getBedRoomData(userId);
    }

    @GetMapping(KITCHEN_API)
    public GetRoomsResponse getKitchenData(@PathVariable Integer userId) {
        return roomsService.getBedRoomData(userId);
    }
}

package com.aasihyaana.aashiyaanabackend.services.roomsservice;

import com.aasihyaana.aashiyaanabackend.exchanges.GetRoomsResponse;

/**
 * The {@code RoomsService} class processes and validates the data required to fetch from database.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
public interface RoomsService {
    
    /**
     * Returns the living rooms data in {@code GetRoomsResponse} object.
     * 
     * @return Returns all the data for living rooms.
     */
    GetRoomsResponse getLivingRoomData(Integer userId);

    /**
     * Returns the Bedroom data in {@code GetRoomsResponse} object.
     * 
     * @return Returns all the data for bedroom.
     */
    GetRoomsResponse getBedRoomData();
    
}

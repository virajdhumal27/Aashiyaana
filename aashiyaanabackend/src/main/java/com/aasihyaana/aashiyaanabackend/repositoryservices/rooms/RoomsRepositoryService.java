package com.aasihyaana.aashiyaanabackend.repositoryservices.rooms;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;

/**
 * The {@code RoomsRepositoryService} interface provides the business logic
 * for converting table entities to POJO and vice versa, and runs the required
 * query that needs to be executed in database.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
public interface RoomsRepositoryService {

    /**
     * Returns a list of all living rooms data from the rooms table.
     * 
     * @return Returns {@code List<Room>} collection if present, else null.
     */
    List<Room> findAllLivingRoomsList();

    /**
     * Returns a list of all bedrooms data form the rooms table.
     * 
     * @return Returns {@code List<Room>} collection if present, else null.
     */
    List<Room> findAllBedRoomsList();

    List<Room> findAllKitchensList();
}
package com.aasihyaana.aashiyaanabackend.exchanges;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code GetRoomsResponse} class object will be sent to templates of living
 * rooms, bedrooms and kitchen frontend as response.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomsResponse {
    private Boolean isLoggedIn;
    private List<Room> rooms;
}

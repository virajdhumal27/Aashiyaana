package com.aasihyaana.aashiyaanabackend.exchanges;

import java.util.List;

import com.aasihyaana.aashiyaanabackend.dto.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomsResponse {
    List<Room> rooms;
}

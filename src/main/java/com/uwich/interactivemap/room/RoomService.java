package com.uwich.interactivemap.room;

import com.uwich.interactivemap.building.BuildingRepository;
import com.uwich.interactivemap.building.BuildingSummary;
import com.uwich.interactivemap.dto.RoomBuildingSummaryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final BuildingRepository buildingRepository;

    // find a room in DB by its ID. if it is not found, throw exception with status code and message
    // Built in JPA method
    public Room getRoomById(Integer id){
        return roomRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }

    // find room(s) in DB based on their name containing value in name param. if none, returns empty list
    // Custom method
    public List<Room> findRoomLikeName(String name){
        return roomRepository.findLikeName(name);
    }

    // find room in DB based on its ID. Then add building details associated with that room. Return object with room and its building
    // if no room exists, throws 404
    //
    public RoomBuildingSummaryDto getRoomWithBuilding(Integer id){
        Optional<Room> room = roomRepository.findById(id);

        if(room.isPresent()){
            BuildingSummary building = buildingRepository.findBuildingById(room.get().getBuildingId());
            return new RoomBuildingSummaryDto(room.get().getId(),room.get().getName(),room.get().getDetails(),room.get().getFloor(),room.get().getType(),room.get().getRoomPhoto(),room.get().getRoomAccessibilityOption()
            ,building);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
        }
    }
}

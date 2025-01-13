package com.uwich.interactivemap.search;

import com.uwich.interactivemap.building.Building;
import com.uwich.interactivemap.building.BuildingService;
import com.uwich.interactivemap.dto.SearchResultDto;
import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class SearchController {
    private final RoomService roomService;
    private final BuildingService buildingService;

    // searches the room and building tables based on client input
    // retrieves each list of objects from the tables and adds each object to the results list.
    @GetMapping("/search")
    public ResponseEntity<List<SearchResultDto>> findRoomLikeName(@RequestParam String name){
        List<Room> roomList = roomService.findRoomLikeName(name);
        List<Building> buildingList = buildingService.findBuildingLikeName(name);
        
        List<SearchResultDto> results = new ArrayList<>();
        roomList.forEach(room -> results.add(new SearchResultDto("Room",roomService.getRoomWithBuilding(room.getId()))));
        buildingList.forEach(building -> results.add(new SearchResultDto("Building",building)));

        return ResponseEntity.ok(results);
    }

}

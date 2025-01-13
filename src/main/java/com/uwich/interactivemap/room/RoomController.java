package com.uwich.interactivemap.room;

import com.uwich.interactivemap.dto.RoomBuildingSummaryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomBuildingSummaryDto> getRoomWithBuildingById(@PathVariable("id") Integer id){
        RoomBuildingSummaryDto room = roomService.getRoomWithBuilding(id);

        return ResponseEntity.ok(room);
    }
}

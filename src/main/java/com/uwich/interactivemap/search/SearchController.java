package com.uwich.interactivemap.search;

import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class SearchController {
    private final RoomService roomService;

    @GetMapping("/search")
    public ResponseEntity<List<Room>> findRoomLikeName(@RequestParam String name){
        List<Room> roomList = roomService.findRoomLikeName(name);

        return ResponseEntity.ok(roomList);
    }

}

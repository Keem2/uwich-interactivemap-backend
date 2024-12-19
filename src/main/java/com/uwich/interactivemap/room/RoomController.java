package com.uwich.interactivemap.room;

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
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id){
        Room room = roomService.getRoomById(id);

        return ResponseEntity.ok(room);
    }
}

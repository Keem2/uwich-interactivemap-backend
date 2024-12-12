package com.uwich.interactivemap.room;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@AllArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable("id") Integer id){
        return roomService.getRoomById(id);
    }
}

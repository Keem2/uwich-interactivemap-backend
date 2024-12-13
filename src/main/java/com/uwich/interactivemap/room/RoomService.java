package com.uwich.interactivemap.room;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    // find a room in DB by its ID. if it is not found, throw exception with status code and message
    // Built in JPA method
    public Room getRoomById(Integer id){
        return roomRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }
}

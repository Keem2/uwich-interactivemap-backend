package com.uwich.interactivemap;

import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.room.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class GetRoomLikeTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private GetRoomLikeTest getRoomLikeTest;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_room_exists_when_get_room_like_return_room(){
        //given
        Room roomOne = new Room();
        roomOne.setId(1);
        roomOne.setName("Room one name");
        roomOne.setBuildingId(1);

        Room roomTwo = new Room();
        roomTwo.setId(2);
        roomTwo.setName("Room two name");
        roomTwo.setBuildingId(1);

        // what is supposed to happen
        when(roomRepository.findLikeName("on")).thenReturn(List.of(roomOne, roomTwo));

        // actual call
        List<Room> roomList = roomRepository.findLikeName("on");

        // asserting expected list is equal to actual list
        Assertions.assertEquals(List.of(roomOne, roomTwo),roomList);
    }
}

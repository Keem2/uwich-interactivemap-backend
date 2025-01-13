package com.uwich.interactivemap.dto;

import com.uwich.interactivemap.building.BuildingIdNameOnly;
import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.roomAccessibilityOptions.roomAccessibilityOptions;
import com.uwich.interactivemap.roomPhoto.roomPhoto;
import com.uwich.interactivemap.type.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
// Data transfer object used to combine room and building into one object
public class RoomBuildingSummaryDto {
    private Integer id;

    private String name;

    private String details;

    private Room.Floor floor;

    private Type type;

    private List<roomPhoto> roomPhoto;

    private List<roomAccessibilityOptions> roomAccessibilityOption;

    private BuildingIdNameOnly building;
}

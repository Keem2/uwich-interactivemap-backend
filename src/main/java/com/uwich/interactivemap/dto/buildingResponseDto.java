package com.uwich.interactivemap.dto;

import com.uwich.interactivemap.building.Building;
import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptions;
import com.uwich.interactivemap.buildingPhoto.buildingPhoto;
import com.uwich.interactivemap.room.Room;
import lombok.Data;

import java.util.List;
import java.util.Optional;

// DTO for specific building by its ID
@Data
public class buildingResponseDto {
    private Integer id;

    private String name;

    private Double latitude;

    private Double longitude;

    private String details;

    private List<Room> room;

    private List<buildingAccessibilityOptions> buildingAccessibilityOption;

    private List<buildingPhoto> buildingPhoto;

    public buildingResponseDto(Optional<Building> building, List<buildingAccessibilityOptions> buildingAccessibilityOption){
        this.id = building.get().getId();
        this.name = building.get().getName();
        this.latitude = building.get().getLatitude();
        this.longitude = building.get().getLongitude();
        this.details = building.get().getDetails();
        this.room = building.get().getRoom();
        this.buildingPhoto = building.get().getBuildingPhoto();
        this.buildingAccessibilityOption = buildingAccessibilityOption;
    }
}

package com.uwich.interactivemap.building;

import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptions;
import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptionsService;
import com.uwich.interactivemap.dto.buildingResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private  final buildingAccessibilityOptionsService buildingAccessibilityOptionsService;

    // get all buildings in DB. Built in JPA method
    public List<Building> getAllBuildings(){
        return buildingRepository.findAll();
    }

    // get building by ID from DB. If building exists, get its accessibility options from DB as well
    // else, return 404
    public buildingResponseDto getBuildingById(Integer id){
        Optional<Building> building = buildingRepository.findById(id);

        if(building.isPresent()){
            List<buildingAccessibilityOptions> buildingAccessibilityOptions = buildingAccessibilityOptionsService.getByBuildingId(id);
            return new buildingResponseDto(building, buildingAccessibilityOptions);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Building not found");
        }

    }
}

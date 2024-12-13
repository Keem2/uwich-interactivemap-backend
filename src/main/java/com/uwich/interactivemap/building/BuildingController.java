package com.uwich.interactivemap.building;

import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptions;
import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptionsService;
import com.uwich.interactivemap.dto.buildingResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class BuildingController {
    private  final BuildingService buildingService;
    private final buildingAccessibilityOptionsService buildingAccessibilityOptionsService;

    // endpoint to get all buildings (excludes their accessibility options)
    @GetMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings();
    }

    // endpoint to get a building's accessibility options only
    @GetMapping("/building/option/{id}")
    public List<buildingAccessibilityOptions> test(@PathVariable("id") Integer id){
        return buildingAccessibilityOptionsService.getByBuildingId(id);
    }

    // endpoint to get specific building by id, including its accessibility options
    @GetMapping("/building/{id}")
    public ResponseEntity<buildingResponseDto> getBuildingById(@PathVariable("id") Integer id){
        buildingResponseDto building = buildingService.getBuildingById(id);

        return ResponseEntity.ok(building);


    }
}

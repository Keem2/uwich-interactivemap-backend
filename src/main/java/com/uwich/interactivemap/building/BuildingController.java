package com.uwich.interactivemap.building;

import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptions;
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

    // endpoint to get all buildings (excludes their accessibility options)
    @GetMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings();
    }

    // endpoint to get specific building by id, including its accessibility options
    @GetMapping("/building/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable("id") Integer id){
        Building building = buildingService.getBuildingById(id);

        return ResponseEntity.ok(building);

    }
}

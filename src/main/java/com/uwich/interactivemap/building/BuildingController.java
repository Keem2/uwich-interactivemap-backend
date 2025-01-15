package com.uwich.interactivemap.building;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class BuildingController {
    private final BuildingService buildingService;

    // endpoint to get all buildings
    @GetMapping("/buildings")
    public ResponseEntity<List<Building>> getAllBuildings(){
        List<Building> buildingList = new ArrayList<>(buildingService.getAllBuildings());

        return ResponseEntity.ok(buildingList);
    }

    // endpoint to get specific building by id
    @GetMapping("/building/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable("id") Integer id){
        Building building = buildingService.getBuildingById(id);

        return ResponseEntity.ok(building);

    }

    // endpoint to get all buildings by type name
    @GetMapping("/building")
    public ResponseEntity<List<Building>> getAllBuildingsByType(@RequestParam String type){
        List<Building> buildingList = new ArrayList<>(buildingService.getBuildingsByTypeName(type));

        return ResponseEntity.ok(buildingList);
    }

}

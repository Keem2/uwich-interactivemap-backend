package com.uwich.interactivemap.building;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BuildingController {
    private  final BuildingService buildingService;

    @GetMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings();
    }
}

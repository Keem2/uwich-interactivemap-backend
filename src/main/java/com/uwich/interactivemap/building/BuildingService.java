package com.uwich.interactivemap.building;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    // get all buildings in DB. Built in JPA method
    public List<Building> getAllBuildings(){
        return buildingRepository.findAll();
    }
}

package com.uwich.interactivemap.building;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    // get all buildings in DB. Built in JPA method
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    // get building by ID from DB. If building does not exist, return 404
    public Building getBuildingById(Integer id) {
        return buildingRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Building not found"));
    }

    // find room(s) in DB based on their name containing value in name param. if none, returns empty list
    // Custom method
    public List<Building> findBuildingLikeName(String name){
        return buildingRepository.findLikeName(name);
    }
}

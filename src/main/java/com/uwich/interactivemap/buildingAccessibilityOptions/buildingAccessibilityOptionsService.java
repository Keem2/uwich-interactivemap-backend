package com.uwich.interactivemap.buildingAccessibilityOptions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class buildingAccessibilityOptionsService {
    private final buildingAccessibilityOptionsRepository buildingAccessibilityOptionsRepository;

    // get building accessibility options by its ID
    public List<buildingAccessibilityOptions> getByBuildingId(Integer buildingId){
        return buildingAccessibilityOptionsRepository.findByBuildingId(buildingId);
    }

}

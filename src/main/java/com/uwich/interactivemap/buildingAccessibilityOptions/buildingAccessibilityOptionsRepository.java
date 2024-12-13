package com.uwich.interactivemap.buildingAccessibilityOptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface buildingAccessibilityOptionsRepository extends JpaRepository <buildingAccessibilityOptions, buildingAccessibilityId> {
    // Query to get a building's accessibility options by its ID
    @Query(
            value = "SELECT * FROM building_accessibility_options WHERE building_id = :buildingId",
            nativeQuery = true
    )
    List<buildingAccessibilityOptions> findByBuildingId(@Param("buildingId") Integer buildingId);

}

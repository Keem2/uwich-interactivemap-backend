package com.uwich.interactivemap.building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    // JPA method to query the building table where building name contains pattern provided in searchTerm
    // Native query
    @Query(value = "SELECT * FROM building WHERE name iLIKE %:searchTerm%", nativeQuery = true)
    List<Building> findLikeName(@Param("searchTerm") String searchTerm);

    // JPA method to find a building by its id and return its id and name only
    BuildingIdNameOnly findBuildingById(Integer id);

    // JPA method to get buildings by their type's name
    List<Building> findByTypeName(String typeName);
}

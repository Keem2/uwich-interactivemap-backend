package com.uwich.interactivemap.buildingAccessibilityOptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uwich.interactivemap.accessibilityOptions.accessibilityOptions;
import com.uwich.interactivemap.building.Building;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "building_accessibility_options")
@Entity
@Data
@IdClass(buildingAccessibilityId.class)
public class buildingAccessibilityOptions {
    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id",nullable = false)
    private Building building;

    @Id
    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id",nullable = false)
    private accessibilityOptions option;
}

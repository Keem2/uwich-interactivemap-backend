package com.uwich.interactivemap.buildingAccessibilityOptions;

import com.uwich.interactivemap.accessibilityOptions.accessibilityOptions;
import com.uwich.interactivemap.building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class buildingAccessibilityId implements Serializable {
    private Building building;

    private accessibilityOptions option;
}

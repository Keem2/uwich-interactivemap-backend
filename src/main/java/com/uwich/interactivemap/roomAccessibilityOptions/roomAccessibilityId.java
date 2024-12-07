package com.uwich.interactivemap.roomAccessibilityOptions;

import com.uwich.interactivemap.accessibilityOptions.accessibilityOptions;
import com.uwich.interactivemap.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

// definition of composite primary key
@Data
@NoArgsConstructor
@AllArgsConstructor
public class roomAccessibilityId implements Serializable {
    private Room roomId;

    private accessibilityOptions optionId;
}

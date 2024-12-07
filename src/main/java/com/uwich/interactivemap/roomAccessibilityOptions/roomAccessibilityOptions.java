package com.uwich.interactivemap.roomAccessibilityOptions;

import com.uwich.interactivemap.accessibilityOptions.accessibilityOptions;
import com.uwich.interactivemap.room.Room;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "room_accessibility_options")
@Entity
@Data
@IdClass(roomAccessibilityId.class)
public class roomAccessibilityOptions {
    @Id
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id",nullable = false)
    private Room roomId;

    @Id
    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id",nullable = false)
    private accessibilityOptions optionId;
}

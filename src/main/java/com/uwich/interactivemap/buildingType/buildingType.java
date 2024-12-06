package com.uwich.interactivemap.buildingType;

import com.uwich.interactivemap.room.Room;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table (name = "building_type")
@Data
@Entity
public class buildingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "type", columnDefinition = "TEXT")
    private String type;

    // establishing the relation on the ONE side of the one to many relation with type and room
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private List<Room> room;
}

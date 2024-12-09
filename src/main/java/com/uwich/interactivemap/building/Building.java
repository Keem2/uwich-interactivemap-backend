package com.uwich.interactivemap.building;

import com.uwich.interactivemap.buildingPhoto.buildingPhoto;
import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.roomPhoto.roomPhoto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "building")
@Data
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "name", columnDefinition = "TEXT")
    private String name;

    @Column (name = "latitude")
    private double latitude;

    @Column (name = "longitude")
    private double longitude;

    @Column (name = "details", columnDefinition = "TEXT")
    private String details;

    // establishing the relation on the ONE side of the one to many relation with building and room
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<Room> room;

    // establishing the relation on the ONE side of the one to many relation with building and building photo
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<buildingPhoto> roomPhoto;

}

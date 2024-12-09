package com.uwich.interactivemap.room;

import com.uwich.interactivemap.roomPhoto.roomPhoto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.List;

@Table (name = "room")
@Data
@Entity

public class Room {
    public enum Floor {
        GROUND, FIRST, SECOND, THIRD
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "building_id")
    private Integer buildingId;

    @Column (name = "name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column (name = "details", columnDefinition = "TEXT")
    private String details;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column (name = "floor")
    private Floor floor;

    @Column (name = "type_id")
    private Integer typeId;

    // establishing the relation on the ONE side of the one to many relation with room and room photo
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private List<roomPhoto> roomPhoto;
}

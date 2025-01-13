package com.uwich.interactivemap.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uwich.interactivemap.roomAccessibilityOptions.roomAccessibilityOptions;
import com.uwich.interactivemap.roomPhoto.roomPhoto;
import com.uwich.interactivemap.type.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.List;

@Table (name = "room")
@Data
@Entity
@Getter
@Setter
public class Room {
    public enum Floor {
        GROUND, FIRST, SECOND, THIRD
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @JsonIgnore
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

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;

    // establishing the relation on the ONE side of the one to many relation with room and room photo
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private List<roomPhoto> roomPhoto;

    // establishing the relation on the ONE side of the one to many relation with room and room access. options
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<roomAccessibilityOptions> roomAccessibilityOption;
}

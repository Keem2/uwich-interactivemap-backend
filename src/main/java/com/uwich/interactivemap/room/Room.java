package com.uwich.interactivemap.room;

import com.uwich.interactivemap.building.Building;
import com.uwich.interactivemap.buildingType.buildingType;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

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
    private Integer building_id;

    @Column (name = "name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column (name = "details", columnDefinition = "TEXT")
    private String details;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column (name = "floor")
    private Floor floor;

    @Column (name = "type_id")
    private Integer type_id;
}

package com.uwich.interactivemap.building;

import com.uwich.interactivemap.buildingAccessibilityOptions.buildingAccessibilityOptions;
import com.uwich.interactivemap.buildingPhoto.buildingPhoto;
import com.uwich.interactivemap.geojson.GeoJSON;
import com.uwich.interactivemap.room.Room;
import com.uwich.interactivemap.type.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Table(name = "building")
@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "name", columnDefinition = "TEXT")
    private String name;

    @Column (name = "details", columnDefinition = "TEXT")
    private String details;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column (name = "geojson", columnDefinition = "jsonb")
    private GeoJSON geojson;

    // establishing the relation on the MANY side of the one to many relation with building and type
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;

    // establishing the relation on the ONE side of the one to many relation with building and room
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<Room> room;

    // establishing the relation on the ONE side of the one to many relation with building and building photo
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<buildingPhoto> buildingPhoto;

    // establishing the relation on the ONE side of the one to many relation with building and building access. options
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<buildingAccessibilityOptions> buildingAccessibilityOption;

}

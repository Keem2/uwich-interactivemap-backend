package com.uwich.interactivemap.type;

import com.uwich.interactivemap.room.Room;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table (name = "type")
@Data
@Entity
public class Type {
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

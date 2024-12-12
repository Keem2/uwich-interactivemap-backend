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

    @Column (name = "name", columnDefinition = "TEXT")
    private String name;

}

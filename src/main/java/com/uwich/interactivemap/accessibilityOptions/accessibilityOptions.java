package com.uwich.interactivemap.accessibilityOptions;

import jakarta.persistence.*;
import lombok.Data;

@Table (name = "accessibility_options")
@Data
@Entity
public class accessibilityOptions {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "name", columnDefinition = "TEXT")
    private String name;

    @Column (name = "icon", columnDefinition = "TEXT")
    private String icon;



}

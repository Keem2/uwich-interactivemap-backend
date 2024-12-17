package com.uwich.interactivemap.accessibilityOptions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table (name = "accessibility_options")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

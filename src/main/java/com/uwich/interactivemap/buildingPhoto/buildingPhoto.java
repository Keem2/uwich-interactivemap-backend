package com.uwich.interactivemap.buildingPhoto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "building_photo")
@Data
@Entity
public class buildingPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "building_id", nullable = false)
    private Integer buildingId;

    @Column(name = "url", columnDefinition = "TEXT", nullable = false)
    private String url;

    @Column(name = "upload_date")
    private Date upload_date;

    @Column(name = "alt_text", columnDefinition = "TEXT")
    private String altText;
}

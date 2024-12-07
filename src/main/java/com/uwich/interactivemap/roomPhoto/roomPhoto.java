package com.uwich.interactivemap.roomPhoto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "room_photo")
@Data
@Entity
public class roomPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "url", columnDefinition = "TEXT", nullable = false)
    private String url;

    @Column(name = "upload_date")
    private Date upload_date;

    @Column(name = "alt_text", columnDefinition = "TEXT")
    private String altText;
}

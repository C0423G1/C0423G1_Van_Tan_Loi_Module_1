package com.example.hotel.model.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_image_avatar")
public class ImageAvatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image_avatar")
    private int idImageAvatar;

    @Column(name = "url_image_avatar")
    private String urlImageAvatar;
    @ManyToOne
    @JoinColumn(name = "id_type_hotel")
    private TypeRoomHotel typeRoomHotel;
}


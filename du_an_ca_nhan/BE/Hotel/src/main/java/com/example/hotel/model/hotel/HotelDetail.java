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
@Table(name = "table_hotel_detail")
public class HotelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel_detail")
    private int idHotelDetail;

    @Column(name = "date_hotel_detail")
    private String dateHotelDetail;

    @Column(name = "price_hotel_detail")
    private double priceHotelDetail;

    @ManyToOne
    @JoinColumn(name = "id_type_hotel")
    private TypeRoomHotel typeRoomHotel;

    // Getters and setters
}


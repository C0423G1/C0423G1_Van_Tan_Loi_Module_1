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
@Table(name = "table_type_room_hotel")
public class TypeRoomHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_hotel")
    private int idTypeHotel;

    @Column(name = "name_type_hotel")
    private String nameTypeHotel;

    @Column(name = "price_type_hotel")
    private double priceTypeHotel;
    private int isDelete;
    private int quantityBed;

    private int numberGuests;
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;


}


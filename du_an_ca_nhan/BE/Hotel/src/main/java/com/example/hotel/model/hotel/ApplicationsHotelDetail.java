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
@Table(name = "table_applications_hotel_detail")
public class ApplicationsHotelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_applications_hotel_detail")
    private int idApplicationsHotelDetail;

    @ManyToOne
    @JoinColumn(name = "id_applications_hotel")
    private ApplicationsHotel applicationsHotel;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    // Getters and setters
}


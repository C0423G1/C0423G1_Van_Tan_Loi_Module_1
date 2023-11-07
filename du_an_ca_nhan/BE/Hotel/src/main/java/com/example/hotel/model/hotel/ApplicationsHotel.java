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
@Table(name = "table_applications_hotel")
public class ApplicationsHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_applications_hotel")
    private int idApplicationsHotel;
    private String card;
    @Column(name = "name_applications_hotel")
    private String nameApplicationsHotel;

}


package com.example.case_study_5_data.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Setter
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceType;
    private String serviceName;
    private double area;
    private double rentalCost;
    private String imageSrc;
    private int maximumOccupancy;
    private String rentalType;
    private String freeAmenities;

}

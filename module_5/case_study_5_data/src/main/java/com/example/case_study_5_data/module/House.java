package com.example.case_study_5_data.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serviceName;
    private double area;
    private double rentalCost;
    private int maximumOccupancy;
    private String rentalType;
    private String imageSrc;
    private String roomStandard;
    private String otherAmenitiesDescription;
    private int numberOfFloors;

}

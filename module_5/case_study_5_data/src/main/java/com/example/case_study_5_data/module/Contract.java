package com.example.case_study_5_data.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Setter
@Getter
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contractNumber;
    private String startDate;
    private String endDate;
    private double advanceDeposit;
    private double totalPayment;

}

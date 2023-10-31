package com.example.case_study_5_data.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "id_card_number")
    private String idCardNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "customer_type")
    private String customerType;
    @Column(name = "address")
    private String address;


    public String getSomeData() {
        return "{id : " + id +
                "fullName : " + fullName +
                "}";
    }
}

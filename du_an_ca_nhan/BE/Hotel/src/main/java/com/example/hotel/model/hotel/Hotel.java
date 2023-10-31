package com.example.hotel.model.hotel;

import com.example.hotel.model.user.customer.EmployeeCustomer;
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
@Table(name = "table_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private int idHotel;

    @Column(name = "name_hotel")
    private String nameHotel;

    @Column(name = "address_hotel")
    private String addressHotel;

    @Column(name = "phone_hotel")
    private String phoneHotel;

    @Column(name = "description_hotel")
    private String descriptionHotel;

    @Column(name = "applications_hotel")
    private String applicationsHotel;

    @ManyToOne
    @JoinColumn(name = "id_employee_customer")
    private EmployeeCustomer employeeCustomer;

    // Getters and setters
}


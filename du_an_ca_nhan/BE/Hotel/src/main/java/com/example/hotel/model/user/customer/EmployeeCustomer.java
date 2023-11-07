package com.example.hotel.model.user.customer;

import com.example.hotel.model.user.role.AppUser;
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
@Table(name = "table_employee_customer")
public class EmployeeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee_customer")
    private int idEmployeeCustomer;

    @Column(name = "name_employee_customer")
    private String nameEmployeeCustomer;

    @Column(name = "cccd_employee_customer")
    private String cccdEmployeeCustomer;

    @Column(name = "phone_employee_customer")
    private String phoneEmployeeCustomer;

    @Column(name = "gender_employee_customer")
    private String genderEmployeeCustomer;

    @Column(name = "email_employee_customer")
    private String emailEmployeeCustomer;

    @Column(name = "address_employee_customer")
    private String addressEmployeeCustomer;

    @Column(name = "stk_employee_customer")
    private String stkEmployeeCustomer;

    @OneToOne
    @JoinColumn(name = "id_account")
    private AppUser user;


}


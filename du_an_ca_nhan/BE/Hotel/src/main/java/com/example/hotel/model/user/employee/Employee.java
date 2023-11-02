package com.example.hotel.model.user.employee;

import com.example.hotel.model.user.role.Account;
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
@Table(name = "table_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private int idEmployee;

    @Column(name = "name_employee")
    private String nameEmployee;

    @Column(name = "cccd_employee")
    private String cccdEmployee;

    @Column(name = "phone_employee")
    private String phoneEmployee;

    @Column(name = "gender_employee")
    private String genderEmployee;

    @Column(name = "wage_employee")
    private double wageEmployee;

    @Column(name = "address_employee")
    private String addressEmployee;

    @ManyToOne
    @JoinColumn(name = "id_type_employee")
    private TypeEmployee typeEmployee;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;

}


package com.example.hotel.model.user.customer;
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
@Table(name = "table_type_customer")
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_customer")
    private int idTypeCustomer;

    @Column(name = "name_type_customer")
    private String nameTypeCustomer;

    @Column(name = "discount_type_customer")
    private double discountTypeCustomer;

}

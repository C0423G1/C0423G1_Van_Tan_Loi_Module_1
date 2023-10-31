package com.example.hotel.model.user.customer;

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
@Table(name = "table_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "cccd_customer")
    private String cccdCustomer;

    @Column(name = "phone_customer")
    private String phoneCustomer;

    @Column(name = "gender_customer")
    private String genderCustomer;

    @Column(name = "stk_customer")
    private String stkCustomer;

    @Column(name = "email_customer")
    private String emailCustomer;

    @Column(name = "address_customer")
    private String addressCustomer;

    @ManyToOne
    @JoinColumn(name = "id_type_customer")
    private TypeCustomer typeCustomer;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;

    // Getters and setters
}


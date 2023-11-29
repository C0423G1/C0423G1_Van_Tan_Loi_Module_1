package com.example.vlwatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class TableCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    private String addressCustomer;
    private String cccdCustomer;
    private String genderCustomer;
    private String nameCustomer;
    private String phoneCustomer;
    private int idTypeCustomer;
    @OneToMany(mappedBy = "tableCustomer")
    private List<TableOrder> tableOrders;
    @OneToOne
    @JoinColumn(name = "id_account")
    private AppUser user;
}


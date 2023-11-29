package com.example.vlwatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TableOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private String dateTimeOrder;
    private String statusOrder;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private TableCustomer tableCustomer;
    @OneToMany(mappedBy = "tableOrder")
    private List<TableOrderDetail> tableOrderDetails;
}

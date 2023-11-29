package com.example.vlwatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TableOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderDetail;
    private double priceWatch;
    private int quantityWatch;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private TableOrder tableOrder;

    @ManyToOne
    @JoinColumn(name = "id_watch")
    private TableWatch tableWatch;
}

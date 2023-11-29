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
public class TableWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWatch;
    private String nameWatch;
    private String phoneWatch;
    private String urlImage;
    private double priceWatch;
    private int quantityWatch;
    @ManyToOne
    @JoinColumn(name = "id_type_watch")
    private TableTypeWatch tableTypeWatch;

    @ManyToOne
    @JoinColumn(name = "id_trademark_watch")
    private TableTrademarkWatch tableTrademarkWatch;

    @ManyToOne
    @JoinColumn(name = "id_machine_type")
    private TableMachineType tableMachineType;

    @OneToMany(mappedBy = "tableWatch")
    private List<TableOrderDetail> tableOrderDetails;
}

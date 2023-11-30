package com.example.vlwatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//ten loai may
public class TableMachineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMachineType;
    private String nameMachineType;

}

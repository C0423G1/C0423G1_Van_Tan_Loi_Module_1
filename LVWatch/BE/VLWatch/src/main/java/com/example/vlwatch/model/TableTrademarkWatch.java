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
//Thuong hieu
public class TableTrademarkWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrademarkWatch;
    private String nameTrademarkWatch;

    // getters and setters
}

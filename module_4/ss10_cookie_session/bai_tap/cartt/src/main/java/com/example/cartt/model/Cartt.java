package com.example.cartt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Cartt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCartt;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;
    private int trangThai;
    private int quantity;

    public Cartt(int idCartt, Product product, int quantity) {
        this.idCartt = idCartt;
        this.product = product;
        this.quantity = quantity;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Cartt() {
    }

    public int getIdCartt() {
        return idCartt;
    }

    public void setIdCartt(int idCartt) {
        this.idCartt = idCartt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


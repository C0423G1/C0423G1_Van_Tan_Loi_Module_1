package com.example.demomvc.model;

public class Product {
    private int id;
    private String name;
    private double gia;
    private String moTa;
    private String nhaSanXuat;

    public Product() {
    }

    public Product(int id, String name, double gia, String moTa, String nhaSanXuat) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.moTa = moTa;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}

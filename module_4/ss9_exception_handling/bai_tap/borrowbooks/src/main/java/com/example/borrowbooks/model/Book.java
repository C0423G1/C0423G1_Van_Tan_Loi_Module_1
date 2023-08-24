package com.example.borrowbooks.model;

import javax.persistence.*;

@Entity
@Table(name = "sach")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sach")
    private int idBook;

    @Column(name = "name_sach")
    private String nameBook;

    @Column(name = "so_luong")
    private int quantity;

    public Book(int idBook, String nameBook, int quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

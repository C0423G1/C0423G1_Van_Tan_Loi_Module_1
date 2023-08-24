package com.example.borrowbooks.model;

import javax.persistence.*;

@Entity
@Table(name = "muon_sach")
public class BorrowBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_muon_sach")
    private int idBorrowBooks;
    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_sach")
    private Book book;

    public BorrowBooks() {
    }

    public int getIdBorrowBooks() {
        return idBorrowBooks;
    }

    public void setIdBorrowBooks(int idBorrowBooks) {
        this.idBorrowBooks = idBorrowBooks;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}


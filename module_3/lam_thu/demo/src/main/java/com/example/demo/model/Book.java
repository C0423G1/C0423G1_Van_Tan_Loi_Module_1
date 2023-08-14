package com.example.demo.model;

public class Book {
    private int idBook ;
    private String title;
    private int pageSize;
    private String author;
    private String category;

    public Book(int idBook, String title, int pageSize, String author, String category) {
        this.idBook = idBook;
        this.title = title;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public Book() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

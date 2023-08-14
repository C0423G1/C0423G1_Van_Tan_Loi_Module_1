package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.IBookingRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingService implements IBookingService{
    IBookingRepository repository = new BookRepository();
    @Override
    public List<Book> display() throws SQLException {
        return repository.display();
    }

    @Override
    public void add(String nameBook, int soLuong, String tacGia, int theLoai) throws SQLException {
        repository.add(nameBook,soLuong,tacGia,theLoai);
    }

    @Override
    public ArrayList<Category> category() throws SQLException {
        return repository.category();
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(id);
    }
}

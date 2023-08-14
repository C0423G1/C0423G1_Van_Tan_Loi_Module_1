package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookingRepository {
    public static final String DISPLAY = "select book.id_book,book.title,book.page_size,book.author,category.name_category \n" +
            "from book \n" +
            "join category on category.id=book.id;";
    public static final String ADDBOOOK = "INSERT INTO demo_thi.book (title,page_size,author,id) VALUES (?,?,?,?);";
    public static final String DISPLAYCATEGORY = "select * from category;";
    public static final String DELETE = "DELETE FROM demo_thi.book WHERE id_book = ?;";

    @Override
    public List<Book> display() throws SQLException {
        Connection connection = BaseRepository.getConnection();
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idBook = resultSet.getInt("id_book");
            String title = resultSet.getString("title");
            int pageSize = resultSet.getInt("page_size");
            String author = resultSet.getString("author");
            String category = resultSet.getString("name_category");
            books.add(new Book(idBook, title, pageSize, author, category));
        }
        return books;
    }

    @Override
    public void add(String nameBook, int soLuong, String tacGia, int theLoai) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADDBOOOK);
        preparedStatement.setString(1, nameBook);
        preparedStatement.setInt(2, soLuong);
        preparedStatement.setString(3, tacGia);
        preparedStatement.setInt(4, theLoai);
        preparedStatement.executeUpdate();
    }

    @Override
    public ArrayList<Category> category() throws SQLException {
        Connection connection = BaseRepository.getConnection();
        ArrayList<Category> categories = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(DISPLAYCATEGORY);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nameCategory = resultSet.getString("name_category");
            categories.add(new Category(id, nameCategory));
        }
        return categories;
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}

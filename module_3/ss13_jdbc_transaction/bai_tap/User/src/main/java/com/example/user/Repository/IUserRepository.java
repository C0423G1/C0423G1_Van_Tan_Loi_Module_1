package com.example.user.Repository;

import com.example.user.Model.Users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IUserRepository {
    List<Users> list() throws SQLException;

    Users findById(int id) throws SQLException;

    void edit(Users users) throws SQLException;

    void delete(int id) throws SQLException;

    void add(Users users) throws SQLException;

    List<Users> arrange() throws SQLException;

    ArrayList<Users> search(String country) throws SQLException;
}

package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.Tours;

import java.sql.SQLException;
import java.util.List;

public interface ITourRepository {
    List<Tours> display() throws SQLException;
}

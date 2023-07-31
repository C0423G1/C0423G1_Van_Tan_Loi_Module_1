package com.example.bookingtour.Service;

import com.example.bookingtour.Model.Tours;

import java.sql.SQLException;
import java.util.List;

public interface ITourService {
    List<Tours> display() throws SQLException;
}

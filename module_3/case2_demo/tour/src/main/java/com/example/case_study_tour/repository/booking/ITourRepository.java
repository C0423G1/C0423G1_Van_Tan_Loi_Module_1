package com.example.case_study_tour.repository.booking;

import com.example.case_study_tour.model.booking.Tours;

import java.sql.SQLException;
import java.util.List;

public interface ITourRepository {
    List<Tours> display() throws SQLException;
}

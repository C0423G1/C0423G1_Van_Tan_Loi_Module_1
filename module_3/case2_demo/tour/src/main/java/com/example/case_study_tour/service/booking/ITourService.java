package com.example.case_study_tour.service.booking;
import com.example.case_study_tour.model.booking.Tours;

import java.sql.SQLException;
import java.util.List;

public interface ITourService {
    List<Tours> display() throws SQLException;
}

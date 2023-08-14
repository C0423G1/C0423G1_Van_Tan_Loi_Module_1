package com.example.case_study_tour.service.booking;

import com.example.case_study_tour.model.booking.Tours;
import com.example.case_study_tour.repository.booking.ITourRepository;
import com.example.case_study_tour.repository.booking.TourRepository;

import java.sql.SQLException;
import java.util.List;

public class TourService implements ITourService {
    ITourRepository repository = new TourRepository();
    @Override
    public List<Tours> display() throws SQLException {
        return repository.display() ;
    }
}

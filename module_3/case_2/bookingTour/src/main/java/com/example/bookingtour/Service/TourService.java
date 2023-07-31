package com.example.bookingtour.Service;

import com.example.bookingtour.Model.Tours;
import com.example.bookingtour.Repository.ITourRepository;
import com.example.bookingtour.Repository.TourRepository;

import java.sql.SQLException;
import java.util.List;

public class TourService implements ITourService {
    ITourRepository repository = new TourRepository();
    @Override
    public List<Tours> display() throws SQLException {
        return repository.display() ;
    }
}

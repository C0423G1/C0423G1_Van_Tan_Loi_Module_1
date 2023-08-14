package com.example.case_study_tour.service.tour;

import com.example.case_study_tour.model.tour.ENameCate;
import com.example.case_study_tour.model.tour.Tour;
import com.example.case_study_tour.model.dto.TourListDTO;

import java.util.List;

public interface ITourService {


    void createTour(Tour tour);


    void deleteTour(int id);

    List<TourListDTO> displayUnDel();


    void editTour(int id, Tour tour);

    Tour findTour(int id);

    TourListDTO findTourDTO(int id);

}

package com.example.case_study_tour.service.tour;

import com.example.case_study_tour.model.tour.TourPlace;
import com.example.case_study_tour.repository.tour.ITourPlaceRepo;
import com.example.case_study_tour.repository.tour.TourPlaceRepo;

import java.util.List;

public class TourPlaceService implements ITourPlaceService{
    ITourPlaceRepo tourPlaceRepo = new TourPlaceRepo();
    @Override
    public List<TourPlace> displayCateP() {
        return tourPlaceRepo.displayCateP();
    }
}

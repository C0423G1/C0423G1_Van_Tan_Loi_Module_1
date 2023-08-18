package com.example.case_study_tour.service.tour;

import com.example.case_study_tour.model.tour.ENameCate;

import java.util.List;

public interface IENameCateService {
    List<ENameCate> displayCateN();


    void updateCate();

    ENameCate getIdAvailable(int employeeId, String s_date, String e_date);

    void updateCateDel();
}

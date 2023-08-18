package com.example.case_study_tour.service.tour;

import com.example.case_study_tour.model.tour.ENameCate;
import com.example.case_study_tour.repository.tour.ENameCateRepo;
import com.example.case_study_tour.repository.tour.IENameCateRepo;

import java.util.List;

public class ENameCateService implements IENameCateService{
    IENameCateRepo nameCateRepo =new ENameCateRepo();

    @Override
    public List<ENameCate> displayCateN() {
        return nameCateRepo.displayCateN();
    }

    @Override
    public void updateCate() {
        nameCateRepo.updateCate();
    }

    @Override
    public ENameCate getIdAvailable(int employeeId, String s_date, String e_date) {
        return nameCateRepo.getIdAvailable(employeeId,s_date,e_date);
    }

    @Override
    public void updateCateDel() {
        nameCateRepo.updateCateDel();
    }
}

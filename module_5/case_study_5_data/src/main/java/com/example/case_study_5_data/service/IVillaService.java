package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVillaService {
    Page<Villa> findAll(Pageable pageable);

    void deleteVilla(int id);

    Villa findAllById(int id);

    void editVilla(int id, Villa villaData);

    void createVilla(Villa villaData);
}

package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Customer;
import com.example.case_study_5_data.module.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHouseService {
    Page<House> findAll(Pageable pageable);

    void deleteHouse(int id);

    House findAllById(int id);

    void editHouse(int id, House houseData);

    void createHouse(House houseData);
}

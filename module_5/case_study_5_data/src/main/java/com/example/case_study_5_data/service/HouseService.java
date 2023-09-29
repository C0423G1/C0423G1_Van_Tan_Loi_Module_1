package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.House;
import com.example.case_study_5_data.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements IHouseService{
    @Autowired
    private IHouseRepository repository;
    @Override
    public Page<House> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteHouse(int id) {
        repository.deleteById(id);
    }

    @Override
    public House findAllById(int id) {
        return repository.ByIdHouse(id);
    }

    @Override
    public void editHouse(int id, House houseData) {
            repository.save(houseData);
    }

    @Override
    public void createHouse(House houseData) {
        House house = repository.save(houseData);
    }
}

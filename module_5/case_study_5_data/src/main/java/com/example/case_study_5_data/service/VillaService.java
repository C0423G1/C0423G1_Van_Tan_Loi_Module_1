package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Villa;
import com.example.case_study_5_data.repository.IVillaRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VillaService implements IVillaService {
    @Autowired
    private IVillaRepository repository;

    @Override
    public Page<Villa> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteVilla(int id) {
        repository.deleteById(id);
    }

    @Override
    public Villa findAllById(int id) {
        return repository.ByIdVilla(id);
    }

    @Override
    public void editVilla(int id, Villa villaData) {
        repository.save(villaData);
    }

    @Override
    public void createVilla(Villa villaData) {
        Villa villa = repository.save(villaData);
    }
}

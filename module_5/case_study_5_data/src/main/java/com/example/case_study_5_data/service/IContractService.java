package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Contract;
import com.example.case_study_5_data.module.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IContractService  {
    Page<Contract> findAll(Pageable pageable);

    void deleteContract(int id);

    Contract findAllById(int id);

    void editContract(int id, Contract contract);

    void createContract(Contract contract);
}

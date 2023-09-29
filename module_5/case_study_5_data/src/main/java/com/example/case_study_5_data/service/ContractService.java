package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Contract;
import com.example.case_study_5_data.module.Customer;
import com.example.case_study_5_data.repository.IContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository repository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteContract(int id) {
        repository.deleteById(id);
    }

    @Override
    public Contract findAllById(int id) {
        return repository.ByIdCustomer(id);
    }

    @Override
    public void editContract(int id, Contract contract) {
        repository.save(contract);
    }

    @Override
    public void createContract(Contract contract) {
        Contract contract1 = repository.save(contract);
    }
}

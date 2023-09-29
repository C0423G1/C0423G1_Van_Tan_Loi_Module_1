package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Customer;
import com.example.case_study_5_data.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    public Page<Customer> findAll(Pageable pageable, String fullName, String customerType) {
        return repository.findAllCustomer(pageable, "%" + fullName + "%", "%" + customerType + "%");
    }

    @Override
    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findAllById(int id) {
        return repository.ByIdCustomer(id);
    }

    @Override
    public void editCustomer(int id, Customer customerData) {
        repository.save(customerData);
    }

    @Override
    public void createCustomer(Customer customerData) {
//        repository.createCustomer(customerData.getFullName(), customerData.getPhoneNumber(), customerData.getIdCardNumber(), customerData.getEmail(),customerData.getDateOfBirth(),customerData.getGender(),customerData.getCustomerType(),customerData.getAddress());
        Customer customer = repository.save(customerData);
        System.out.println(customer);
    }
}

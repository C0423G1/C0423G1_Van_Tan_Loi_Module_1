package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable,String fullName,String customerType);

    void deleteCustomer(int id);

    Customer findAllById(int id);

    void editCustomer(int id, Customer customerData);

    void createCustomer(Customer customerData);
}

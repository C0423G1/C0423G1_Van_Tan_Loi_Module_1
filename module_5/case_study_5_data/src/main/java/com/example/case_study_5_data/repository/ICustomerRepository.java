package com.example.case_study_5_data.repository;

import com.example.case_study_5_data.module.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customer WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

    @Query(value = "SELECT * FROM customer where id = :id", nativeQuery = true)
    Customer ByIdCustomer(int id);

    @Query(value = "SELECT * from customer where full_name like :fullName OR customer_type like :customerType ", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable, String fullName, String customerType);

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO customer (address,customer_type,date_of_birth,email,full_name,gender,id_card_number) VALUES (:fullName,:phoneNumber,:idCardNumber,:email,:dateOfBirth,:gender,:customerType,:address)", nativeQuery = true)
//    void createCustomer(String fullName, String phoneNumber, String idCardNumber, String email, String dateOfBirth, String gender, String customerType, String address);
}

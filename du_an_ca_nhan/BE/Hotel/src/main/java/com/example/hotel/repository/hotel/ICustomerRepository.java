package com.example.hotel.repository.hotel;

import com.example.hotel.model.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}

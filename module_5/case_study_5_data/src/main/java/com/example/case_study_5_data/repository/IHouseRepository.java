package com.example.case_study_5_data.repository;

import com.example.case_study_5_data.module.Customer;
import com.example.case_study_5_data.module.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IHouseRepository extends JpaRepository<House, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM house WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

    @Query(value = "SELECT * FROM house where id = :id", nativeQuery = true)
    House ByIdHouse(int id);
}

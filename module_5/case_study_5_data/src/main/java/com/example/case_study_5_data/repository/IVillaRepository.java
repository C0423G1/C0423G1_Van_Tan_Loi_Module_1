package com.example.case_study_5_data.repository;

import com.example.case_study_5_data.module.Customer;
import com.example.case_study_5_data.module.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IVillaRepository extends JpaRepository<Villa,Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM villa WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

    @Query(value = "SELECT * FROM villa where id = :id", nativeQuery = true)
    Villa ByIdVilla(int id);
}

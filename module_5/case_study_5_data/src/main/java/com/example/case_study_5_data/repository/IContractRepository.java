package com.example.case_study_5_data.repository;

import com.example.case_study_5_data.module.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



import javax.transaction.Transactional;
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contract WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

    @Query(value = "SELECT * FROM contract where id = :id", nativeQuery = true)
    Contract ByIdCustomer(int id);
}

package com.example.case_study_5_data.repository;

import com.example.case_study_5_data.module.Room;
import com.example.case_study_5_data.module.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM room WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

    @Query(value = "SELECT * FROM room where id = :id", nativeQuery = true)
    Room ByIdRoom(int id);
}

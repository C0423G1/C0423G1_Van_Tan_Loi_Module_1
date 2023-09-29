package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Room;
import com.example.case_study_5_data.module.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomService {
    Page<Room> findAll(Pageable pageable);

    void deleteRoom(int id);

    Room findAllById(int id);

    void editRoom(int id, Room room);

    void createRoom(Room room);
}

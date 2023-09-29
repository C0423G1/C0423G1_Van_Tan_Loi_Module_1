package com.example.case_study_5_data.service;

import com.example.case_study_5_data.module.Room;
import com.example.case_study_5_data.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository repository;
    @Override
    public Page<Room> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteRoom(int id) {
    repository.deleteById(id);
    }

    @Override
    public Room findAllById(int id) {
        return repository.ByIdRoom(id);
    }

    @Override
    public void editRoom(int id, Room room) {
        repository.save(room);
    }

    @Override
    public void createRoom(Room room) {
        Room room1 = repository.save(room);
    }
}

package com.example.cartt.repository;

import com.example.cartt.model.Cartt;
import com.example.cartt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cartt,Integer> {
    @Query(value = "select * from cartt where trang_thai = 0", nativeQuery = true)
    List<Cartt> findAll();
    @Query(value = "select * from cartt where trang_thai = 0 AND id=:id", nativeQuery = true)
    List<Cartt> listId(int id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cartt (quantity,trang_thai,id) VALUES (1,0,:id);", nativeQuery = true)
    void listIdCreate(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE cartt SET quantity = quantity+1 WHERE trang_thai = 0 AND id=:id", nativeQuery = true)
    void idCreate(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE cartt SET trang_thai = 1 WHERE trang_thai = 0", nativeQuery = true)
    void success();
}

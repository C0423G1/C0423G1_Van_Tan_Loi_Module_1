package com.example.demo1.repository;

import com.example.demo1.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IImageRepository extends JpaRepository<Image,Integer> {
@Modifying
@Transactional
@Query(value = "INSERT INTO image (name) VALUES (:file1)",nativeQuery = true)
    void saveFile(String file1);
}

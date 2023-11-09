package com.example.hotel.repository.hotel;

import com.example.hotel.model.hotel.ImageAvatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface IImageRepository extends JpaRepository<ImageAvatar,Integer> {
    @Query(value = "SELECT ia.* " +
            "FROM table_image_avatar ia " +
            "JOIN table_type_room_hotel trh ON ia.id_type_hotel = trh.id_type_hotel " +
            "WHERE trh.id_hotel = :id",nativeQuery = true)
    ArrayList<ImageAvatar> findByIdIamge(Long id);
}

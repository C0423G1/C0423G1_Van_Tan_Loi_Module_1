package com.example.hotel.repository.hotel;

import com.example.hotel.model.hotel.TypeRoomHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ITypeRoomRepository extends JpaRepository<TypeRoomHotel,Integer> {
    @Query(value = "SELECT * FROM table_type_room_hotel where id_hotel = :id",nativeQuery = true)
    ArrayList<TypeRoomHotel> findAllByIdTypeRoom(Long id);
}

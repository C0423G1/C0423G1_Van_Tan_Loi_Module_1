package com.example.hotel.repository.hotel;


import com.example.hotel.dto.OrderBillDto;
import com.example.hotel.dto.PayRoomDto;
import com.example.hotel.dto.TypeRoomDto;
import com.example.hotel.model.hotel.TypeRoomHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ITypeRoomRepository extends JpaRepository<TypeRoomHotel, Integer> {

    @Query(value = "SELECT " +
            "trh.id_type_hotel AS idTypeHotel, " +
            "trh.is_delete AS isDelete, " +
            "trh.name_type_hotel AS nameTypeHotel, " +
            "trh.number_guests AS numberGuests, " +
            "trh.price_type_hotel AS priceTypeHotel, " +
            "trh.quantity_bed AS quantityBed, " +
            "trh.quantity_room AS quantityRoom, " +
            "trh.id_hotel AS idHotel, " +
            "trh.quantity_room - IFNULL(ob.total_quantity, 0) AS available " +
            "FROM " +
            "table_type_room_hotel AS trh " +
            "LEFT JOIN ( " +
            "SELECT " +
            "id_type_hotel, " +
            "SUM(quantity) AS total_quantity " +
            "FROM " +
            "table_order_bill " +
            "WHERE " +
            "date_start <= :startDate AND date_end >= :endDate " +
            "AND status_order = 'Đã thanh toán'" +
            "GROUP BY " +
            "id_type_hotel " +
            ") AS ob ON trh.id_type_hotel = ob.id_type_hotel " +
            "WHERE " +
            "trh.id_hotel = :id " +
            "ORDER BY available DESC", nativeQuery = true)
    ArrayList<TypeRoomDto> findAllByIdTypeRoom(int id, String endDate, String startDate);

    @Query(value = "SELECT " +
            "ttrh.id_type_hotel AS IdTypeHotel, " +
            "ttrh.is_delete AS IsDelete, " +
            "ttrh.name_type_hotel AS NameTypeHotel, " +
            "ttrh.number_guests AS NumberGuests, " +
            "ttrh.price_type_hotel AS PriceTypeHotel, " +
            "ttrh.quantity_bed AS QuantityBed, " +
            "ttrh.quantity_room AS QuantityRoom, " +
            "ttrh.id_hotel AS IdHotel, " +
            "tob.quantity AS Quantity " +
            "FROM table_type_room_hotel ttrh " +
            "JOIN table_order_bill tob ON ttrh.id_type_hotel = tob.id_type_hotel " +
            "JOIN table_hotel th ON ttrh.id_hotel = th.id_hotel " +
            "WHERE tob.date_end = :endDate " +
            "AND tob.date_start = :startDate " +
            "AND tob.id_customer = :checkIdUser " +
            "AND tob.status_order = 'Chưa thanh toán' " +
            "AND th.id_hotel = :id ", nativeQuery = true)
    ArrayList<PayRoomDto> getRoomPay(int checkIdUser, int id, String startDate, String endDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE table_order_bill " +
            "SET name_customer = :fullName, phone_customer = :phoneNumber,status_order='Đã thanh toán' " +
            "WHERE id_type_hotel = :idTypeHotel " +
            "AND date_end = :endDate " +
            "AND date_start = :startDate " +
            "AND id_customer = :checkIdUser " +
            "AND status_order = 'Chưa thanh toán'", nativeQuery = true)
    void pay(int checkIdUser, int idTypeHotel, String startDate, String endDate, String fullName, String phoneNumber);
    @Query(value = "SELECT " +
            "trh.quantity_room - COALESCE(SUM(CASE WHEN toa.status_order = 'Đã thanh toán' THEN toa.quantity ELSE 0 END), 0) AS available_rooms " +
            "FROM " +
            "table_type_room_hotel trh " +
            "LEFT JOIN " +
            "table_order_bill toa " +
            "ON trh.id_type_hotel = toa.id_type_hotel " +
            "AND ( " +
            "(toa.date_start >= :startDate AND toa.date_start <= :endDate) " +
            "OR (toa.date_end >= :startDate AND toa.date_end <= :endDate) " +
            "OR (:startDate >= toa.date_start AND :endDate <= toa.date_end) " +
            ") " +
            "WHERE " +
            "trh.id_type_hotel = :typeHotel " +
            "GROUP BY " +
            "trh.id_type_hotel, " +
            "trh.name_type_hotel, " +
            "trh.quantity_room",nativeQuery = true)
    Integer checkRoom(int typeHotel, String startDate, String endDate);
    @Query(value = "SELECT COALESCE(SUM(CASE WHEN toa.status_order = 'Chưa thanh toán' THEN toa.quantity ELSE 0 END), 0) AS available_rooms " +
            "FROM table_type_room_hotel trh " +
            "LEFT JOIN table_order_bill toa ON trh.id_type_hotel = toa.id_type_hotel " +
            "AND ( " +
            "(toa.date_start >= :startDate AND toa.date_start <= :endDate) " +
            "OR (toa.date_end >= :startDate AND toa.date_end <= :endDate) " +
            "OR (:startDate >= toa.date_start AND :endDate <= toa.date_end) " +
            ") " +
            "WHERE trh.id_type_hotel = :typeHotel AND toa.id_customer = :id " +
            "GROUP BY trh.id_type_hotel, trh.name_type_hotel, trh.quantity_room", nativeQuery = true)
    Integer checkRoomUnpaid(@Param("typeHotel") int typeHotel, int id,@Param("startDate") String startDate, @Param("endDate") String endDate);

}

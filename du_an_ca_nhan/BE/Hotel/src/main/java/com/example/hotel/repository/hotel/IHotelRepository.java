package com.example.hotel.repository.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT" +
            " h.id_hotel as IdHotel ," +
            "h.address_hotel as AddressHotel ," +
            "h.description_hotel as DescriptionHotel ," +
            "h.name_hotel as NameHotel," +
            "h.url_image as UrlImage," +
            "MIN(t.price_type_hotel) AS MinPriceTypeHotel," +
            "CASE" +
            " WHEN (SUM(o.quantity) - t.quantity_room) > 0 THEN SUM(o.quantity) - t.quantity_room" +
            " ELSE 0" +
            " END AS AvailableRooms" +
            " FROM" +
            " table_hotel h" +
            " LEFT JOIN" +
            " table_type_room_hotel t ON h.id_hotel = t.id_hotel" +
            " LEFT JOIN" +
            " table_order_bill o ON t.id_type_hotel = o.id_type_hotel" +
            " AND o.date_start <= :endDate" +
            " AND o.date_end >= :startDate" +
            " WHERE" +
            " t.number_guests <= :numberOfGuests" +
            " AND t.is_delete = 0" +
            " AND h.address_hotel = :selectedLocation" +
            " GROUP BY" +
            " h.id_hotel, h.address_hotel, h.description_hotel, h.name_hotel, h.url_image, t.quantity_room", nativeQuery = true)
    ArrayList<HotelDto> findSreach(String selectedLocation, String startDate, String endDate, int numberOfGuests);
    @Query(value = "SELECT " +
            "h.id_hotel AS IdHotel, " +
            "h.address_hotel AS AddressHotel, " +
            "h.description_hotel AS DescriptionHotel, " +
            "h.name_hotel AS NameHotel, " +
            "h.url_image AS UrlImage, " +
            "MIN(t.price_type_hotel) AS MinPriceTypeHotel, " +
            "COALESCE(" +
            "CASE " +
            "WHEN (SUM(o.quantity) - t.quantity_room) > 0 THEN SUM(o.quantity) - t.quantity_room " +
            "ELSE 0 " +
            "END, " +
            "t.quantity_room" +
            ") AS AvailableRooms " +
            "FROM table_hotel h " +
            "LEFT JOIN table_type_room_hotel t ON h.id_hotel = t.id_hotel " +
            "LEFT JOIN table_order_bill o ON t.id_type_hotel = o.id_type_hotel " +
            "WHERE t.number_guests <= 2 AND t.is_delete = 0 AND h.id_hotel = :id " +
            "GROUP BY " +
            "h.id_hotel, h.address_hotel, h.description_hotel, h.name_hotel, h.url_image, t.quantity_room",nativeQuery = true)
    HotelDto findByIdHotel(Long id);


}

package com.example.hotel.repository.hotel;

import com.example.hotel.dto.ApplicationsDto;
import com.example.hotel.dto.HotelDto;
import com.example.hotel.dto.OrderBillDto;
import com.example.hotel.model.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
            "h.id_hotel, h.address_hotel, h.description_hotel, h.name_hotel, h.url_image, t.quantity_room", nativeQuery = true)
    HotelDto findByIdHotel(Long id);

    @Query(value = "SELECT table_applications_hotel.id_applications_hotel AS idApplicationsHotel," +
            "table_applications_hotel.card AS card," +
            "table_applications_hotel.name_applications_hotel AS nameApplicationsHotel " +
            "FROM table_applications_hotel " +
            "LEFT JOIN table_applications_hotel_detail ON table_applications_hotel.id_applications_hotel = table_applications_hotel_detail.id_applications_hotel " +
            "WHERE table_applications_hotel_detail.id_hotel = :id", nativeQuery = true)
    ArrayList<ApplicationsDto> findByIdApplications(Long id);

    @Query(value = "SELECT tc.id_customer " +
            "FROM table_customer AS tc " +
            "JOIN app_user AS au ON tc.id_account = au.id " +
            "WHERE au.user_name = :nameUser", nativeQuery = true)
    int findByNameUser(String nameUser);

    @Query(value = "SELECT " +
            "id_order AS IdOrder," +
            "date_end AS DateEnd ," +
            "date_order AS DateOrder," +
            "date_start AS DateStart," +
            "quantity AS Quantity ," +
            "status_order AS StatusOrder," +
            "sum_price AS SumPrice " +
            "FROM " +
            "hotell.table_order_bill " +
            "WHERE " +
            "date_end = :endDate " +
            "AND date_start = :startDate " +
            "AND id_customer = :checkIdUser " +
            "AND id_type_hotel = :idTypeHotel AND status_order='Chưa thanh toán'", nativeQuery = true)
    ArrayList<OrderBillDto> checkAddRoomm(int checkIdUser, int idTypeHotel, String startDate, String endDate);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO table_order_bill (date_start,date_order, date_end, id_customer, id_type_hotel, status_order, quantity, sum_price) " +
            "SELECT :startDate,CURRENT_DATE(), :endDate, :checkIdUser, :idTypeHotel, 'Chưa thanh toán', 1, 1 * price_type_hotel " +
            "FROM table_type_room_hotel " +
            "WHERE id_type_hotel = :idTypeHotel", nativeQuery = true)
    void addRoom(int checkIdUser, int idTypeHotel, String startDate, String endDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE table_order_bill AS ob " +
            "JOIN table_type_room_hotel AS th ON ob.id_type_hotel = th.id_type_hotel " +
            "SET ob.quantity = ob.quantity + 1, " +
            "ob.sum_price = (ob.quantity + 1) * th.price_type_hotel, " +
            "ob.date_order = CURRENT_DATE() " +
            "WHERE ob.date_start = :startDate " +
            "AND ob.date_end = :endDate " +
            "AND ob.id_customer = :checkIdUser " +
            "AND ob.id_type_hotel = :idTypeHotel AND ob.status_order='Chưa thanh toán'", nativeQuery = true)
    void addQuanityTypeRoom(int checkIdUser, int idTypeHotel, String startDate, String endDate);

    @Query(value = "SELECT ob.id_order AS IdOrder " +
            "FROM table_order_bill AS ob " +
            "INNER JOIN table_type_room_hotel AS th ON ob.id_type_hotel = th.id_type_hotel " +
            "WHERE ob.date_end = :endDate " +
            "AND ob.date_start = :startDate " +
            "AND ob.status_order = 'Chưa thanh toán' " +
            "AND ob.id_customer = :checkIdUser " +
            "AND ob.quantity > 0 " +
            "AND th.id_hotel = :id", nativeQuery = true)
    ArrayList<OrderBillDto> checkPay(int checkIdUser, int id,String startDate, String endDate);


}

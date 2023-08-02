package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.BookingDto;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
    List<BookingDto> display(int id) throws SQLException;

    void addQuantity(int id, int idCustomer) throws SQLException;

    void deleteQuantity(int id, int idCustomer) throws SQLException;

    void deleteQuantityCart(int id, int idCustomer) throws SQLException;
}

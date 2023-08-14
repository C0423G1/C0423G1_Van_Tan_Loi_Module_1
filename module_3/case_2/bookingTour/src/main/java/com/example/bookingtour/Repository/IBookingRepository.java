package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.FromDto;
import com.example.bookingtour.Model.RoleDto;
import com.example.bookingtour.Model.TourEmailDto;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
    List<BookingDto> display(int id) throws SQLException;

    void addQuantity(int id, int idCustomer) throws SQLException;

    void deleteQuantity(int id, int idCustomer) throws SQLException;

    void deleteQuantityCart(int id, int idCustomer) throws SQLException;

    void success(int customerId ) throws SQLException;

    List<RoleDto> displayRole() throws SQLException;

    List<RoleDto> displaySuccess() throws SQLException;

    List<RoleDto> displayFailure( String startDate, String endDate) throws SQLException;

    List<RoleDto> displayChart(int month, int year) throws SQLException;

    List<TourEmailDto> displayEmail(int customerId) throws SQLException;

    void quantityList(int id) throws SQLException;

    int checkQuantity(int id, int customerId, int quantity) throws SQLException;

    FromDto displayFrom(int customerId) throws SQLException;
}

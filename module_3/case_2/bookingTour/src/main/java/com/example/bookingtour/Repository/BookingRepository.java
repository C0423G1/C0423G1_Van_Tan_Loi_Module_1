package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.Bookings;
import com.example.bookingtour.Model.Tours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository{
    public static final String DISPLAY = "select tours.tour_name" +
            ",customers.customer_name ," +
            "tours.tour_price," +
            "bookings.quantity " +
            "from tours " +
            "join bookings on tours.tour_id = bookings.tour_id " +
            "join customers on customers.customer_id = bookings.customer_id;";
    @Override
    public List<BookingDto> display() throws SQLException {
            Connection connection = BaseRepository.getConnection();
            ArrayList<BookingDto> arraylist = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tourName = resultSet.getString("tour_name");
                String customerName = resultSet.getString("customer_name");
                String tourPrice = resultSet.getString("tour_price");
                int quantity = resultSet.getInt("quantity");
                arraylist.add(new BookingDto(tourName,customerName,tourPrice,quantity));
            }
            return arraylist;

    }
}

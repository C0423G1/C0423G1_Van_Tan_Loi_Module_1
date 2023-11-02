package com.example.hotel.repository.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.model.hotel.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
//    @Query()
//    Page<HotelDto> findAllSreach(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation);
//

}

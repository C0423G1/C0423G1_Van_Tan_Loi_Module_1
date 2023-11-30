package com.example.vlwatch.repository.product;

import com.example.vlwatch.dto.product_home.IWatchHome;
import com.example.vlwatch.model.TableWatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IProductRepository extends JpaRepository<TableWatch,Integer> {
    @Query(value = "SELECT id_watch AS watchId ," +
            "name_watch AS nameWatch," +
            "price_watch AS price ," +
            "url_image AS imageUrl " +
            "FROM table_watch where id_type_watch = 1 LIMIT 4",nativeQuery = true)
    ArrayList<IWatchHome> watchMaleHome();
    @Query(value = "SELECT id_watch AS watchId ," +
            "name_watch AS nameWatch," +
            "price_watch AS price ," +
            "url_image AS imageUrl " +
            "FROM table_watch where id_type_watch = 2 LIMIT 4",nativeQuery = true)
    ArrayList<IWatchHome> watchFemaleHome();
}

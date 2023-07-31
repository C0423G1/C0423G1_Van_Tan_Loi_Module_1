package com.example.demomvc.repository;

import com.example.demomvc.model.Product;

import javax.xml.transform.Result;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    public static final String DISPLAY = "select*from products";

//    int count = arrayList.size();


    @Override
    public void add(Product product) {
//        arrayList.put(product.getId(), product);
    }

    @Override
    public List<Product> display() throws SQLException {
        Connection connection = BaseRepository.getConnection();
        ArrayList<Product> arraylist = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("product_name");
            double price = resultSet.getDouble("product_price");
            String description = resultSet.getString("product_description");
            String manufacturer = resultSet.getString("manufacturer");
            arraylist.add(new Product(id, name, price, description, manufacturer));
        }
        return arraylist;
    }

    @Override
    public void delete(int index) {
//        arrayList.remove(index);
    }

    @Override
    public Product findById(int id) {
            return new Product();
//        return arrayList.get(id);
    }

    @Override
    public void edit(Product product) {
//        arrayList.put(product.getId(), product);
    }

    @Override
    public int autoId() {
        return 0;
    }

    @Override
    public void remove(int id) {
//        arrayList.remove(id);
    }

}

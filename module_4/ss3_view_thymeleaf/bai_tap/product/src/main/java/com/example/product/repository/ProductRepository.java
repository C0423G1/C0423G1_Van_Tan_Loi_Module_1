package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private static final Map<Integer, Product> product;

    static {
        product = new HashMap<>();
        product.put(1, new Product(1, "Bàn Phím", 1000000, "Dùng cho máy tính", "Ha Noi"));
        product.put(2, new Product(2, "Màn Máy Tính", 200000, "Dùng cho máy tính", "Hai Phong"));
        product.put(3, new Product(3, "Chuột máy tính", 300000, "Dùng cho máy tính", "Sai Gon"));
    }
    public List<Product> findAll() {
        return new ArrayList<>(product.values());
    }

    @Override
    public void create(Product products) {
        product.put(products.getId(),products) ;
    }
    public void delete(int id) {
        product.remove(id);
    }
    public Product findById(int id) {
        return product.get(id);
    }
}

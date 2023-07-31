package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    public static Map<Integer, Product> arrayList = new HashMap<>();

    static {
        arrayList.put(1, new Product(1, "Giáo Khoa", 10000, "Dùng cho lớp 121", "Kim Đồng"));
        arrayList.put(2, new Product(2, "Giáo Khoa", 100000, "Dùng cho lớp 12", "Kim Đồng"));
        arrayList.put(3, new Product(3, "Giáo Khoa", 1000000, "Dùng cho lớp 122", "Kim Đồng"));
        arrayList.put(4, new Product(4, "Giáo Khoa", 10000000, "Dùng cho lớp 125", "Kim Đồng"));
        arrayList.put(5, new Product(5, "Giáo Khoa", 1000000000, "Dùng cho lớp 127", "Kim Đồng"));
    }

    int count = arrayList.size();


    @Override
    public void add(Product product) {
        arrayList.put(product.getId(), product);
    }

    @Override
    public List<Product> display() {

        return new ArrayList<>(arrayList.values());
    }

    @Override
    public void delete(int index) {
        arrayList.remove(index);
    }

    @Override
    public Product findById(int id) {

        return arrayList.get(id);
    }

    @Override
    public void edit(Product product) {
        arrayList.put(product.getId(), product);
    }

    @Override
    public int autoId() {
        return count;
    }

    @Override
    public void remove(int id) {
        arrayList.remove(id);
    }

}

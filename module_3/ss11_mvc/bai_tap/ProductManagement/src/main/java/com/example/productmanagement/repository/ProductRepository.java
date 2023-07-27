package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
    public static ArrayList<Product> arrayList = new ArrayList<>();

    static {
        arrayList.add(new Product(1, "Giáo Khoa", 10000, "Dùng cho lớp 121", "Kim Đồng"));
        arrayList.add(new Product(2, "Giáo Khoa", 100000, "Dùng cho lớp 12", "Kim Đồng"));
        arrayList.add(new Product(3, "Giáo Khoa", 1000000, "Dùng cho lớp 122", "Kim Đồng"));
        arrayList.add(new Product(4, "Giáo Khoa", 10000000, "Dùng cho lớp 125", "Kim Đồng"));
        arrayList.add(new Product(5, "Giáo Khoa", 1000000000, "Dùng cho lớp 127", "Kim Đồng"));
    }


    @Override
    public void add(Product product) {
    arrayList.add(product);
    }

    @Override
    public ArrayList<Product> display() {
        return arrayList;
    }

    @Override
    public void delete() {

    }
    @Override
    public Product findById(int id) {
        return arrayList.get(id);
    }
    public void editName(int id,String name){
        arrayList.get(id).setName(name);
    }
    public void editGia(int id,double gia){
        arrayList.get(id).setGia(gia);
    }
    public void editMoTa(int id,String moTa){
        arrayList.get(id).setName(moTa);
    }
    public void editNhaSanXuat(int id,String nhaSanXuat){
        arrayList.get(id).setName(nhaSanXuat);
    }
}

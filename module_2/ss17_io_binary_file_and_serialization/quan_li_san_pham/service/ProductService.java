package ss17_io_binary_file_and_serialization.quan_li_san_pham.service;

import ss17_io_binary_file_and_serialization.quan_li_san_pham.controller.MenuProduct;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.model.ProductManagement;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.repository.IProductRepository;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Tên Sản Phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá tiền ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Nước Sản Xuất");
        String manufacture = scanner.nextLine();
        System.out.println("Mô Tả");
        String describe = scanner.nextLine();
        ProductManagement productManagement = new ProductManagement(id, name, price, manufacture, describe);
        productRepository.add(productManagement);
    }

    @Override
    public void display() {
        List<ProductManagement> list = productRepository.display();
        for (ProductManagement pr : list) {
            System.out.println(pr);
        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID Bạn Muốn Xem ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn Có Chắc Chắn Muốn Hiển Thị ID " + id + "Không ?" +
                "\n1.Có" +
                "\n2.Không");
        int check = Integer.parseInt(scanner.nextLine());
        if (check == 1) {
            productRepository.Search(id);
        }
    }
}

package ss12_java_collection_framework.mvc.service;


import ss12_java_collection_framework.mvc.model.ProductModel;
import ss12_java_collection_framework.mvc.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời Bạn Nhập Tên Sách");
        String name = scanner.nextLine();
        ProductModel productModel = new ProductModel(id, name);
        productRepository.add(productModel);
    }

    @Override
    public void display() {
        List<ProductModel> product = productRepository.display();
        for (ProductModel pr : product) {
            System.out.println(pr);
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID Bạn Muốn Sửa");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn có chắn chắn muốn sửa ID" + id + " không" +
                "\n1.Có" +
                "\n2.Không");
        int check = Integer.parseInt(scanner.nextLine());
        if (check == 1) {
            productRepository.edit(id);
        }

    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID Bạn Muốn Xoá");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn có chắn chắn muốn xoá ID" + id + " không" +
                "\n1.Có" +
                "\n2.Không");
        int check = Integer.parseInt(scanner.nextLine());
        if (check == 1) {
            productRepository.delete(id);
        }

    }

    @Override
    public void arrange() {
        productRepository.arrange();
    }
}

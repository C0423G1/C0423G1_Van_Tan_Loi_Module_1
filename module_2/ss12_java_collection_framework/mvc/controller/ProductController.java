package ss12_java_collection_framework.mvc.controller;


import ss12_java_collection_framework.mvc.service.ProductService;

import java.util.Scanner;

public class ProductController {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("1.Để Hiển Thị " +
                    "\n2.Thêm Mới Sách" +
                    "\n3.Xoá Sách" +
                    "\n4.Sắp xếp sách" +
                    "\n5.Sửa Thông Tin" +
                    "\n6.Thoát");
            int a = Integer.parseInt(scanner.nextLine());
            switch (a) {
                case 1:
                    System.out.println("---------------------Danh Sách Sách ------------------");
                    productService.display();
                    break;
                case 2:
                    System.out.println("---------------------Thêm Mới Sách---------------------");
                    productService.add();
                    break;
                case 3:
                    System.out.println("---------------------Xoá Sách---------------------");
                    productService.delete();
                    break;
                case 4:
                    System.out.println("---------------------Sắp Xếp Sách---------------------");
                    productService.arrange();
                    break;
                case 5:
                    System.out.println("--------------------- Sửa Thông Tin--------------------");
                    productService.edit();
                    break;
                case 6:
                    flag = true;
                    break;
            }
        } while (!flag);

    }

}

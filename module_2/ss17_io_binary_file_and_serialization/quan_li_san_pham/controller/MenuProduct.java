package ss17_io_binary_file_and_serialization.quan_li_san_pham.controller;

import m_v_c_tong_hop.util.ReadStudentTeacher;
import ss15_exception.TriangleEdgesException;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.service.ProductService;

import java.util.Scanner;

public class MenuProduct {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("---------------------------- Bắt Đầu Chương Trình-----------------------------");
        do {
            System.out.println("1. Thêm sản Phẩm mới " + "\n2.Hiển Thị Danh Sách Sản Phẩm" + "\n3.Tìm Thông Tin Sản Phẩm " + "\n4.Thoát");
            boolean flagOne = true;
            do {
                try {
                    flagOne = true;
                    int check = Integer.parseInt(scanner.nextLine());
                    switch (check) {
                        case 1:
                            System.out.println("-------------------- Thêm Sản Phẩm Mới----------------------");
                            productService.add();
                            flag = true;
                            break;
                        case 2:
                            System.out.println("----------------------- Danh Sách Sản Phẩm-------------------");
                            productService.display();
                            flag = true;
                            break;
                        case 3:
                            System.out.println("-----------------------Thông Tin Sản Phẩm Cần Tìm -----------------------");
                            productService.search();
                            flag = true;
                            break;
                        case 4:
                            flag = false;
                            System.out.println("--------------------------- Kết Thúc Chương Trình-------------------------------");
                            break;
                        default:
                            flag = false;
                            System.out.println("Lỗi Không Đúng Chức Năng");
                    }
                } catch (Exception ex) {
                    flagOne = false;
                    System.out.println("Lỗi controller");
                    ex.printStackTrace();
                }
            } while (flagOne == false);
        } while (flag);
    }
}

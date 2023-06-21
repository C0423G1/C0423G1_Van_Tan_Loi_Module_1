package ss10_dsa_danh_sach.mvc.controller;

import ss10_dsa_danh_sach.mvc.service.StudentService;

import java.util.Scanner;

public class StudentController {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("1.Để Hiển Thị " +
                    "\n2.Thêm Học Sinh Mới" +
                    "\n3.Xoá Học Sinh" +
                    "\n4.Thoát");
            int a = Integer.parseInt(scanner.nextLine());
            switch (a) {
                case 1:
                    System.out.println("------------ Thông Tin Học Viên -------------");
                    studentService.display();
                    flag = false;
                    break;
                case 2:
                    System.out.println("------------- Thêm Học Viên Mới --------------");
                    flag = false;
                    studentService.add();
                    break;
                case 3:
                    System.out.println("-------------Xoá Học Viên----------------------");
                    studentService.detele();
                    flag = false;
                    break;
                case 4:
                    flag = true;
                    break;
            }
        } while (!flag);
    }

}

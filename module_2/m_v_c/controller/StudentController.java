package m_v_c.controller;

import m_v_c.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static StudentService studentService = new StudentService();

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng :" +
                    "\n1. Display" +
                    "\n2. Add" +
                    "\n3.Delete" +
                    "\n4.Edit" +
                    "\n5.Search" +
                    "\n6.Exit");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("--------chức năng hiển thị----------");
                    // code hiển thị
                    studentService.display();
                    break;
                case 2:
                    System.out.println("-----------Thêm mới-----------------");
                    studentService.add();
                    break;
                case 3:
                    System.out.println("-------------Xoá-----------------------");
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}

package m_v_c_tong_hop.controller;

import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.service.StudentService;
import m_v_c_tong_hop.service.TeacherService;
import m_v_c_tong_hop.util.ReadStudentTeacher;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanController {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("1.Để Hiển Thị " + "\n2.Thêm Học Sinh Mới/Giáo Viên" + "\n3.Xoá Học Sinh/Giáo Viên" + "\n4.Thoát");
            int a = Integer.parseInt(scanner.nextLine());
            switch (a) {
                case 1:
                    System.out.println("Mời Bạn Chọn thông tin hiển thị :" + "\n1.Học Viên" + "\n2.Giáo Viên" + "\n3.Học Viên Và Giáo Viên");
                    int u = Integer.parseInt(scanner.nextLine());
                    if (u == 1) {
                        System.out.println("------------ Thông Tin Học Viên -------------");
                        studentService.display();
                    } else if (u == 2) {
                        System.out.println("------------ Thông Tin Giáo Viên -------------");
                        teacherService.display();
                    } else if (u == 3) {
                        System.out.println("------------ Thông Tin Học Viên -------------");
                        studentService.display();
                        System.out.println("------------ Thông Tin Giáo Viên -------------");
                        teacherService.display();
                    }
                    flag = false;
                    break;
                case 2:
                    System.out.println("Mời Bạn Chọn Thông Tin Bạn Muốn Thêm :" + "\n1.Học Viên" + "\n2.Giáo Viên");
                    int check = Integer.parseInt(scanner.nextLine());
                    if (check == 1) {
                        System.out.println("---------------- Thêm Thông Tin Học Viên--------------");
                        studentService.add();
                    } else if (check == 2) {
                        System.out.println("----------------- Thêm Thông Tin Giáo Viên--------------");
                        teacherService.add();
                    }
                    flag = false;
                    break;
                case 3:
                    System.out.println("Mời Bạn Chọn Thông Tin Bạn Muốn Thêm :" + "\n1.Học Viên" + "\n2.Giáo Viên");
                    int i = Integer.parseInt(scanner.nextLine());
                    if (i == 1) {
                        System.out.println("-------------Xoá Học Viên----------------------");
                        studentService.detele();
                    } else if (i == 2) {
                        System.out.println("----------------- Xoá Giáo Viên--------------");
                        teacherService.detele();
                    }
                    flag = false;
                    break;
                case 4:
                    flag = true;
                    break;
            }
        } while (!flag);
    }

}

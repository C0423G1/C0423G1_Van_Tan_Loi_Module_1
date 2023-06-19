package ss10_dsa_danh_sach.mvc.service;

import ss10_dsa_danh_sach.mvc.model.StudentModel;

import java.util.Scanner;

public class StudentService implements IStudentService {
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm id học viên");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm tên học viên");
        String name = scanner.nextLine();
        System.out.println("Thêm Ngày Sinh Học viên");
        String date = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập Lớp");
        String classStudent = scanner.nextLine();
        System.out.println("Nhập Điểm Số");
        int score = Integer.parseInt(scanner.nextLine());
        StudentModel studentModel = new StudentModel(id,name,date,gender,classStudent,score);
        studentModel.add(studentModel);

    }

    @Override
    public void Detele() {

    }

    @Override
    public void Display() {

    }
}

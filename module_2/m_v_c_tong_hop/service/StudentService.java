package m_v_c_tong_hop.service;


import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IHumanService {
    public StudentRepository studentRepository = new StudentRepository();

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
        Student student = new Student(id, name, date, gender, classStudent, score);
        studentRepository.add(student);
    }

    @Override
    public void detele() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID bạn muốn xoá ");
        int id = Integer.parseInt(scanner.nextLine());
        studentRepository.detele(id);

    }

    @Override
    public void display() {
        List<Student> students = studentRepository.getHumanList();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}

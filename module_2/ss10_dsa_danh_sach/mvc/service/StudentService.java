package ss10_dsa_danh_sach.mvc.service;

import ss10_dsa_danh_sach.mvc.model.StudentModel;
import ss10_dsa_danh_sach.mvc.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();

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
        StudentModel studentModel = new StudentModel(id, name, date, gender, classStudent, score);
        studentRepository.add(studentModel);
    }

    @Override
    public void detele() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id bạn muốn xoá");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn có muốn xoá không" +
                "\n1.Có" +
                "\n2.Không");
        int b = Integer.parseInt(scanner.nextLine());
        if (b == 1) {
            studentRepository.delete(a);
        }

    }

    @Override
    public void display() {
        List<StudentModel> studentModelList = studentRepository.display();
        for (StudentModel student : studentModelList) {
            System.out.println(student);
        }
    }
}

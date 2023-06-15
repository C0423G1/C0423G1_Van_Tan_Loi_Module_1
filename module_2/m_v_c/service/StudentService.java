package m_v_c.service;

import m_v_c.model.Student;
import m_v_c.repository.StudentRepository;

import java.util.Scanner;

public class StudentService implements IStudentService {
    private final StudentRepository studentRepository = new StudentRepository();
    @Override
    public void display() {
       Student[] students =studentRepository.display();
       // hiển thị
        for (int i = 0; i <students.length ; i++) {
            System.out.println(students[i]);
        }
    }

    @Override
    public void add() {
      // nhập dữ liệu
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập giới tính");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập lớp");
        String className = scanner.nextLine();
        Student student = new Student(id,name,gender,className);
        studentRepository.add(student);
    }

    @Override
    public void delete() {

    }
}

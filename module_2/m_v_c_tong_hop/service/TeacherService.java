package m_v_c_tong_hop.service;

import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;
import m_v_c_tong_hop.repository.IHumanRepository;
import m_v_c_tong_hop.repository.TeacherRepository;
import ss19_string_regex.validate_class.NameExample;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements IHumanService {
    public static NameExample nameExample = new NameExample();
    public TeacherRepository teacherRepository = new TeacherRepository();

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm id giáo viên");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm tên giáo viên");
        String name = scanner.nextLine();
        boolean flag = true;
        boolean check;
        do {
            check = nameExample.checkName(name);
            flag = true;
            if (check == false) {
                flag = false;
                System.out.println("Nhập lại");
                String nameCheck = scanner.nextLine();
                name = nameCheck;
            }
        } while (!flag);
        System.out.println("Thêm Ngày giáo viên");
        String date = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập chuyên môn");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, date, gender, specialize);
        teacherRepository.add(teacher);

    }

    @Override
    public void detele() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Bạn Nhập ID bạn muốn xoá ");
        int id = Integer.parseInt(scanner.nextLine());
        teacherRepository.detele(id);

    }

    @Override
    public void display() {
        List<Teacher> teachers = teacherRepository.getHumanList();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

    }

}

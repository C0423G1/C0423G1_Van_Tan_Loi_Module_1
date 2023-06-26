package m_v_c_tong_hop.repository;

import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;
import m_v_c_tong_hop.util.ReadStudentTeacher;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepository implements IHumanRepository<Student> {
    static public ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyễn Văn A", "19/10/2020", "Nam", "C04", 100));
        students.add(new Student(2, "Nguyễn Văn B", "10/10/2020", "Nữ", "C04", 100));
        students.add(new Student(3, "Nguyễn Văn B", "19/11/2020", "Nam", "C04", 100));
    }


    public void add(Student student) {
        students.add(student);

    }


    @Override
    public ArrayList<Student> getHumanList() {
        ReadStudentTeacher.writeStudent(students, false);
        return students;
    }


    @Override
    public void detele(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn có chắn chắn muốn xoá ID " + id + " Của Học Viên Không :" +
                "\n1.Có" +
                "\n2.Không");
        int check = Integer.parseInt(scanner.nextLine());
        if (check == 1) {
            for (int i = 0; i < students.size(); i++) {
                if (id == students.get(i).getId()) {
                    students.remove(i);
                }
            }
        }
    }
}

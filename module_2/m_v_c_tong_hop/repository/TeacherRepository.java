package m_v_c_tong_hop.repository;

import m_v_c_tong_hop.model.Humana;
import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;
import m_v_c_tong_hop.util.ReadStudentTeacher;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherRepository implements IHumanRepository<Teacher> {
    static public ArrayList<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Nguyễn Văn F", "11/01/2020", "Nữ", "Sinh Học"));
        teachers.add(new Teacher(2, "Nguyễn Văn O", "18/11/2020", "Nam", "Hoá Học"));
        teachers.add(new Teacher(3, "Nguyễn Văn Z", "15/10/2020", "Nữ", "Toán Học"));
    }


    @Override
    public void add(Teacher teacher) {

        teachers.add(teacher);
    }

    @Override
    public ArrayList<Teacher> getHumanList() {
        ReadStudentTeacher.writeTeacher(teachers, true);
        return teachers;
    }


    @Override
    public void detele(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn có chắn chắn muốn xoá ID " + id + " Của Học Viên Không :" +
                "\n1.Có" +
                "\n2.Không");
        int check = Integer.parseInt(scanner.nextLine());
        if (check == 1) {
            for (int i = 0; i < teachers.size(); i++) {
                if (id == teachers.get(i).getId()) {
                    teachers.remove(i);
                }
            }
        }
    }
}

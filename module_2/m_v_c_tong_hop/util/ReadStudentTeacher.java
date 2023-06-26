package m_v_c_tong_hop.util;

import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReadStudentTeacher {
    public static void writeStudent(ArrayList<Student> students, boolean append) {
        try {
            FileWriter fw = new FileWriter("m_v_c_tong_hop/data/student_teacher.csv", append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeTeacher(ArrayList<Teacher> teachers, boolean append) {
        try {
            FileWriter fw = new FileWriter("m_v_c_tong_hop/data/student_teacher.csv", append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Teacher s : teachers) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}


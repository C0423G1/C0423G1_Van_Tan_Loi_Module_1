package m_v_c_tong_hop.util;

import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Student> readStudent() {
        List<Student> students = new ArrayList<>();
        try {
            FileReader fr = new FileReader("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\m_v_c_tong_hop\\data\\student_teacher.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] test = line.split(",");
                int id = Integer.parseInt(test[0]);
                String name = test[1];
                String date = test[2];
                String gender = test[3];
                String classStudent = test[4];
                int core = Integer.parseInt(test[5]);
                students.add(new Student(id, name, date, gender, classStudent, core));

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> readBinary() {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\m_v_c_tong_hop\\data\\student.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static void write(List<Student> students) {
        try {
            FileOutputStream fo = new FileOutputStream("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\m_v_c_tong_hop\\data\\student.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(students);
            oo.close();
            fo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


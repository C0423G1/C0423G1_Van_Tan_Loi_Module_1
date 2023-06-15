package m_v_c.repository;

import m_v_c.model.Student;

public class StudentRepository implements IStudentRepository {
    // biến static
    static Student[] students = new Student[5];
    // khối static
    static {
       students[0]= new Student(1,"chánh1",true,"C04");
       students[1]= new Student(2,"chánh2",true,"C04");
       students[2]= new Student(3,"chánh3",true,"C04");
    }
    @Override
    public Student[] display() {
        // đọc file
        return students;
    }

    @Override
    public void add(Student student) {
        for (int i = 0; i <students.length ; i++) {
            if (students[i]==null){
                students[i]= student;
                break;
            }

        }
    }

    @Override
    public void delete() {

    }
}

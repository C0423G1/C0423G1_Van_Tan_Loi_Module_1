package m_v_c.repository;

import m_v_c.model.Student;

public interface IStudentRepository {
    Student[] display();
    void add(Student student);
    void delete();
}

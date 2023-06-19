package ss10_dsa_danh_sach.mvc.repository;

import ss10_dsa_danh_sach.mvc.model.StudentModel;

import java.util.ArrayList;

public interface IStudentRepository {
    void add(StudentModel student);
    ArrayList<StudentModel> display();
    void delete(StudentModel id);
}

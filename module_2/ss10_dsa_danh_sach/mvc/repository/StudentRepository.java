package ss10_dsa_danh_sach.mvc.repository;


import ss10_dsa_danh_sach.mvc.model.StudentModel;

import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {
    public static void main(String[] args) {
        ArrayList<StudentModel> student = new ArrayList<>();
        student.add(new StudentModel(1, "Nguyễn văn A", "16/06/2022", "Nam", "c04", 80));
        student.add(new StudentModel(1, "Nguyễn văn B", "16/05/2022", "Nam", "c04", 80));
        student.add(new StudentModel(1, "Nguyễn văn C", "16/03/2022", "Nam", "c04", 80));
    }


    @Override
    public void add() {

    }
}

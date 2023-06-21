package m_v_c_tong_hop.repository;

import m_v_c_tong_hop.model.Humana;
import m_v_c_tong_hop.model.Student;
import m_v_c_tong_hop.model.Teacher;

import java.util.ArrayList;

public interface IHumanRepository<T> {
    void add(T t);


    ArrayList<T> getHumanList();


    void detele(int id);


}

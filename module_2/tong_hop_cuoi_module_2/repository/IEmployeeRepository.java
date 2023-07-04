package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.model.Facility;

import java.util.List;

public interface IEmployeeRepository {
    void add(Employee employees);


    void fix(String id, int number, String function);

    List<Employee> display();

    boolean checkID(String id);
}

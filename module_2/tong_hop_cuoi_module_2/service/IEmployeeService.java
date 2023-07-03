package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Employee;

import java.util.List;

public interface IEmployeeService extends Service {

    List<Employee> display();

    void add();

    void fix();


}

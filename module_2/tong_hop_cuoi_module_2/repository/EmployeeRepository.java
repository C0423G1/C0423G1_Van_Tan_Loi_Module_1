package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.service.EmployeeService;
import tong_hop_cuoi_module_2.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository implements IEmployeeRepository {
    public static final String FILE_EMPLOYEE = "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv";

    @Override
    public void add(Employee employees) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read(FILE_EMPLOYEE);
        employeess.add(employees);
        WriteAndRead.write(employeess, FILE_EMPLOYEE, false);
    }


    @Override
    public void fix(String id, int number, String function) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read(FILE_EMPLOYEE);
        for (int i = 0; i < employeess.size(); i++) {
            if (id.equals(employeess.get(i).getId())) {
                switch (number) {
                    case 1:
                        employeess.get(i).setId(function);
                        break;
                    case 2:
                        employeess.get(i).setName(function);
                        break;
                    case 3:
                        employeess.get(i).setDate(function);
                        break;
                    case 4:
                        employeess.get(i).setGender(function);
                        break;
                    case 5:
                        employeess.get(i).setNumberName(function);
                        break;
                    case 6:
                        employeess.get(i).setNumberName(function);
                        break;
                    case 7:
                        employeess.get(i).setEmail(function);
                        break;
                    case 8:
                        employeess.get(i).setLevel(function);
                        break;
                    case 9:
                        employeess.get(i).setPosition(function);
                        break;
                    case 10:
                        employeess.get(i).setWage(Long.parseLong(function));
                }
            }
        }
        WriteAndRead.write(employeess, FILE_EMPLOYEE, false);

    }

    @Override
    public List<Employee> display() {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read(FILE_EMPLOYEE);
        return employeess;
    }

    @Override
    public boolean checkID(String id) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read(FILE_EMPLOYEE);
        for (int i = 0; i < employeess.size(); i++) {
            if (id.equals(employeess.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
}

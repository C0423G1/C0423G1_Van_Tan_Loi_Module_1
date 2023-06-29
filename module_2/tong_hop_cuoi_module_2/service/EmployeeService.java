package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.repository.EmployeeRepository;
import tong_hop_cuoi_module_2.repository.IEmployeeRepository;
import tong_hop_cuoi_module_2.util.CheckLevel;
import tong_hop_cuoi_module_2.util.CheckPosition;
import tong_hop_cuoi_module_2.util.CheckYear;
import tong_hop_cuoi_module_2.util.Regex;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();


    @Override
    public void display() {
        List<Employee> list = employeeRepository.display();
        for (Employee pr : list) {
            System.out.println(pr);
        }
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String id;
        boolean flagCheck = false;
        do {
            do {
                System.out.println("Please Enter ID");
                id = scanner.nextLine();
            } while (!Regex.checkID(id));
            if (employeeRepository.checkID(id) == false) {
                flagCheck = false;
            } else {
                flagCheck = true;
            }
        } while (flagCheck == false);
        String name;
        do {
            System.out.println("Please Enter Name");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        String date;
        do {
            System.out.println("Please Enter Date");
            date = scanner.nextLine();
        } while (!CheckYear.is18YearsOld(date));
        System.out.println("Please Enter Gender");
        String gender = scanner.nextLine();
        String numberName;
        do {
            System.out.println("Please Enter NumberName");
            numberName = scanner.nextLine();
        } while (!Regex.checkNumberName(numberName));
        String numberPhone;
        do {
            System.out.println("Please Enter NumberPhone");
            numberPhone = scanner.nextLine();
        } while (!Regex.checkNumberPhone(numberPhone));
        String email;
        do {
            System.out.println("Please Enter Email");
            email = scanner.nextLine();
        } while (!Regex.checkEmail(email));
        String level ;
        do {
            System.out.println("Please Enter Level (Trung cấp, Cao đẳng, Đại học và Sau đại học )");
            level = scanner.nextLine();
        } while (!CheckLevel.checkLevel(level));
        String position ;
        do {
            System.out.println("Please Enter Position( lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.) ");
            position = scanner.nextLine();
        } while (!CheckPosition.checkPosition(position));
        long wage;
        boolean flag = true;
        do {
            System.out.println("Please Enter Wage");
            wage = Long.parseLong(scanner.nextLine());
            if (wage > 0) {
                flag = false;
            }
        } while (flag);
        Employee employee = new Employee(id, name, date, gender, numberName, numberPhone, email, level, position, wage);
        employeeRepository.add(employee);

    }

    @Override
    public void fix() {
        Scanner scanner = new Scanner(System.in);
        boolean flagCheck = false;
        String id;
        do {
            System.out.println("Enter the ID you want to edit");
            id = scanner.nextLine();
            if (employeeRepository.checkID(id) == true) {
                flagCheck = false;
            } else {
                flagCheck = true;
            }
        } while (flagCheck == false);
        boolean flag = true;
        do {
            System.out.println("Are you sure" +
                    "\n1.Yes" +
                    "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flag = false;
                    employeeRepository.fix(id);
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flag);

    }


}

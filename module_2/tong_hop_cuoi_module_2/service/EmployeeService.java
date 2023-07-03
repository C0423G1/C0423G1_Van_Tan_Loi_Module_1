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
    public List<Employee> display() {
        List<Employee> list = employeeRepository.display();
        for (Employee pr : list) {
            System.out.println(pr);
        }
        return list;
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String id;
        boolean flagCheck = false;
        do {
            do {
                System.out.println("Nhập Mã Nhân Viên Mới (NV-XXXX ,X : số từ 0-9)");
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
            System.out.println("Nhập Tên Nhân Viên Mới( Chữ cái đầu của mỗi từ phải viết hoa)");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        String date;
        do {
            System.out.println("Nhập Ngày Tháng Năm Sinh :Trên 18+ (XX-YY-MMMM , XX: Ngày , YY : Tháng , MMMM : Năm , )");
            date = scanner.nextLine();
        } while (!CheckYear.is18YearsOld(date));
        System.out.println("Mời Nhập Giới Tính");
        String gender = scanner.nextLine();
        String numberName;
        do {
            System.out.println("Nhập Chính Minh Nhân Dân Mới(9 số - 12 số)");
            numberName = scanner.nextLine();
        } while (!Regex.checkNumberName(numberName));
        String numberPhone;
        do {
            System.out.println("Nhập Số Điện Thoại (Bắt đầu bằng 0, Đủ 10 số)");
            numberPhone = scanner.nextLine();
        } while (!Regex.checkNumberPhone(numberPhone));
        String email;
        do {
            System.out.println("Mời Nhập Địa Chỉ email");
            email = scanner.nextLine();
        } while (!Regex.checkEmail(email));
        String level;
        do {
            System.out.println("Mời Nhập Trình Độ Học Vấn");
            level = scanner.nextLine();
        } while (!CheckLevel.checkLevel(level));
        String position;
        do {
            System.out.println("Mời Nhập Vị trí ");
            position = scanner.nextLine();
        } while (!CheckPosition.checkPosition(position));
        long wage;
        boolean flag = true;
        do {
            System.out.println("Mời Nhập Mức Lương");
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

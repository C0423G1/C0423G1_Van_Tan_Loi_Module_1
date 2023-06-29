package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.service.EmployeeService;
import tong_hop_cuoi_module_2.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository implements IEmployeeRepository {

    @Override
    public void add(Employee employees) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv");
        employeess.add(employees);
        WriteAndRead.write(employeess, "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv", false);
    }


    @Override
    public void fix(String id) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv");
        Scanner scanner = new Scanner(System.in);
        boolean flagName = true;
        do {
            String name;
            do {
                System.out.println("Do you want to change the name ?");
                name = scanner.nextLine();
            } while (!Regex.checkName(name));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagName = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setName(name);
                        }
                    }
                    break;
                case 2:
                    flagName = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagName);

        boolean flagDate = true;
        do {
            String date;
            do {
                System.out.println("Do you want to change your date of birth?");
                date = scanner.nextLine();
            } while (!CheckYear.is18YearsOld(date));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagDate = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setDate(date);
                        }
                    }
                    break;
                case 2:
                    flagDate = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagDate);
        boolean flagGender = true;
        do {
            System.out.println("Do you want to change your Gender?");
            String gender = scanner.nextLine();
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagGender = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setGender(gender);
                        }
                    }
                    break;
                case 2:
                    flagGender = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagGender);
        boolean flagNumberName = true;
        do {
            String numberName;
            do {
                System.out.println("Do you want to change your number name?");
                numberName = scanner.nextLine();
            } while (!Regex.checkNumberName(numberName));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagNumberName = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setNumberName(numberName);
                        }
                    }
                    break;
                case 2:
                    flagNumberName = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagNumberName);
        boolean flagNumberPhone = true;
        do {
            String numberPhone;
            do {
                System.out.println("Do you want to change your number Phone?");
                numberPhone = scanner.nextLine();
            } while (!Regex.checkNumberPhone(numberPhone));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagNumberPhone = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setNumberPhone(numberPhone);
                        }
                    }
                    break;
                case 2:
                    flagNumberPhone = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagNumberPhone);
        boolean flagEmail = true;
        do {
            String email;
            do {
                System.out.println("Do you want to change your email?");
                email = scanner.nextLine();
            } while (!Regex.checkEmail(email));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagEmail = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setEmail(email);
                        }
                    }
                    break;
                case 2:
                    flagEmail = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagEmail);
        boolean flagLevel = true;
        do {
            String level;
            do {
                System.out.println("Do you want to change your Level (Trung cấp, Cao đẳng, Đại học và Sau đại học )");
                level = scanner.nextLine();
            } while (!CheckLevel.checkLevel(level));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagLevel = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setLevel(level);
                        }
                    }
                    break;
                case 2:
                    flagLevel = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagLevel);
        boolean flagPosition = true;
        do {
            String position;
            do {
                System.out.println("Do you want to change your Position( lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.) ");
                position = scanner.nextLine();
            } while (!CheckPosition.checkPosition(position));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagPosition = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setPosition(position);
                        }
                    }
                    break;
                case 2:
                    flagPosition = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagPosition);
        boolean flagWage = true;
        do {
            boolean flag = true;
            long wage;
            do {
                System.out.println("Do you want to change your wage?");
                wage = Long.parseLong(scanner.nextLine());
                if (wage > 0) {
                    flag = false;
                }
            } while (flag);
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagWage = false;
                    for (int i = 0; i < employeess.size(); i++) {
                        if (id.equals(employeess.get(i).getId())) {
                            employeess.get(i).setWage(wage);
                        }
                    }
                    break;
                case 2:
                    flagWage = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagWage);
        WriteAndRead.write(employeess, "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv", false);

    }

    @Override
    public List<Employee> display() {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv");
        return employeess;
    }

    @Override
    public boolean checkID(String id) {
        List<Employee> employeess = new ArrayList<>();
        employeess = WriteAndRead.read("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv");
        for (int i = 0; i < employeess.size(); i++) {
            if (id.equals(employeess.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
}

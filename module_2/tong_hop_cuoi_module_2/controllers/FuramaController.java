package tong_hop_cuoi_module_2.controllers;


import tong_hop_cuoi_module_2.service.EmployeeService;

import java.util.Scanner;

public class FuramaController {
    private static EmployeeService employeeService = new EmployeeService();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------- Bắt Đầu Chương Trình ---------------------------------------");
        boolean flag = true;
        AD:
        do {
            System.out.println("1. Employee Management" + "\n2. Customer Management" + "\n3. Facility Management" + "\n4. Booking Management" + "\n5. Promotion Management" + "\n6. Exit");
            boolean flagCheck = true;
            do {
                flagCheck = true;
                try {
                    int menu = Integer.parseInt(scanner.nextLine());
                    switch (menu) {
                        case 1:
                            do {
                                flagCheck = true;
                                try {
                                    System.out.println("-----------------  Employee Management --------------- ");
                                    boolean flagEmployee = true;
                                    do {
                                        flagEmployee = true;
                                        System.out.println("1 Display list employees" + "\n2 Add new employee" + "\n3 Edit employee" + "\n4 Return main menu");
                                        int menuOne = Integer.parseInt(scanner.nextLine());
                                        switch (menuOne) {
                                            case 1:
                                                employeeService.display();
                                                break;
                                            case 2:
                                                employeeService.add();
                                                break;
                                            case 3:
                                                employeeService.fix();
                                                break;
                                            case 4:
                                                flagEmployee = false;
                                                continue AD;
                                            default:
                                                flagEmployee = false;
                                                System.out.println("Nhập Lại");
                                                break;
                                        }
                                    } while (!flagEmployee);
                                } catch (NumberFormatException e) {
                                    System.out.println("Error : Wrong Data Type 1");
                                    flagCheck = false;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Error : Wrong Data Type 1");
                                    flagCheck = false;
                                }
                            } while (flagCheck);
                            break;
                        case 2:
                            do {
                                flagCheck = true;
                                try {
                                    System.out.println("-----------------   Customer Management --------------- ");
                                    System.out.println("1. Display list customers" + "\n2. Add new customer" + "\n3. Edit customer" + "\n4. Return main menu");
                                    int menuTwo = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type 2");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 3:
                            do {
                                System.out.println("-----------------   Facility Management --------------- ");
                                System.out.println("1 Display list facility" + "\n2 Add new facility" + "\n3 Display list facility maintenance" + "\n4 Return main menu");
                                flagCheck = true;
                                try {
                                    int menuThree = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type 3");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 4:
                            do {
                                System.out.println("-----------------   Booking Management --------------- ");
                                System.out.println("1. Add new booking" + "\n2. Display list booking" + "\n3. Create new contracts" + "\n4. Display list contracts" + "\n5. Edit contracts" + "\n6. Return main menu");
                                flagCheck = true;
                                try {
                                    int menuFour = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type 4");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 5:
                            do {
                                System.out.println("----------------- Promotion Management --------------- ");
                                System.out.println("1. Display list customers use service" + "\n2. Display list customers get voucher" + "\n3. Return main menu");
                                flagCheck = true;
                                try {
                                    int menuFive = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type 5");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 6:
                            flag = false;
                            System.out.println("----------------------- Kết Thúc Chương Trình------------------------");
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("Error : Wrong Data Type 0");
                    flagCheck = false;
                }
            } while (flagCheck == false);

        } while (flag);
    }
}

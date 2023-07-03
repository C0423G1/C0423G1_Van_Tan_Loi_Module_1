package tong_hop_cuoi_module_2.controllers;


import tong_hop_cuoi_module_2.model.Facility;
import tong_hop_cuoi_module_2.service.CustomerService;
import tong_hop_cuoi_module_2.service.EmployeeService;
import tong_hop_cuoi_module_2.service.FacilityService;

import java.util.Scanner;

public class FuramaController {
    private static EmployeeService employeeService = new EmployeeService();
    private static CustomerService customerService = new CustomerService();
    private static FacilityService facilityService = new FacilityService();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------- Bắt Đầu Chương Trình ---------------------------------------");
        boolean flag = true;
        AD:
        do {
            System.out.println("1. Quản lý nhân viên" + "\n2. Quản lý khách hàng" + "\n3. Quản lý cơ sở" + "\n4. Quản lý đặt chỗ" + "\n5. Quản lý khuyến mãi" + "\n6. Thoát");
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
                                    System.out.println("-----------------   Quản lý nhân viên --------------- ");
                                    boolean flagEmployee = true;
                                    do {
                                        flagEmployee = true;
                                        System.out.println("1 Hiển thị danh sách nhân viên" + "\n2 Thêm nhân viên mới" + "\n3 Chỉnh sửa nhân viên" + "\n4 Quay lại menu chính");
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
                                                System.out.println("Nhập Lại Ngoài Phạm Vi Truy Cập");
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
                                    System.out.println("-----------------   Quản lý khách hàng --------------- ");
                                    boolean flagCustomer = true;
                                    do {
                                        flagCustomer = true;
                                        System.out.println("1. Hiển thị danh sách khách hàng" + "\n2. Thêm khách hàng mới" + "\n3. Chỉnh sửa khách hàng" + "\n4. Quay lại menu chính");
                                        int menuTwo = Integer.parseInt(scanner.nextLine());
                                        switch (menuTwo) {
                                            case 1:
                                                customerService.display();
                                                break;
                                            case 2:
                                                customerService.add();
                                                break;
                                            case 3:
                                                customerService.fix();
                                                break;
                                            case 4:
                                                flagCustomer = false;
                                                continue AD;
                                            default:
                                                flagCustomer = false;
                                                System.out.println("Nhập Lại Ngoài Phạm Vi Truy Cập");
                                                break;
                                        }
                                    } while (!flagCustomer);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Error : Wrong Data Type 2");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 3:
                            do {
                                flagCheck = true;
                                try {
                                    System.out.println("-----------------   Facility Management --------------- ");
                                    boolean flagFacility = true;
                                    AC:
                                    do {
                                        flagFacility = true;
                                        System.out.println("1 Cơ sở danh sách hiển thị" + "\n2 Thêm cơ sở mới" + "\n3 Hiển thị danh sách bảo trì cơ sở" + "\n4 Quay lại menu chính");
                                        int menuThree = Integer.parseInt(scanner.nextLine());
                                        switch (menuThree) {
                                            case 1:
                                                facilityService.display();
                                                break;
                                            case 2:
                                                System.out.println("---------------Add New Facility-----------------");
                                                boolean flagNewFacility = true;
                                                do {
                                                    flagNewFacility = true;
                                                    System.out.println("1. Thêm biệt thự mới" + "\n2. Thêm nhà mới" + "\n3. Thêm phòng mới" + "\n4. Quay lại menu");
                                                    int checkNewFacility = Integer.parseInt(scanner.nextLine());
                                                    switch (checkNewFacility) {
                                                        case 1:
                                                            facilityService.add(checkNewFacility);
                                                            break;
                                                        case 2:
                                                            facilityService.add(checkNewFacility);
                                                            break;
                                                        case 3:
                                                            facilityService.add(checkNewFacility);
                                                            break;
                                                        case 4:
                                                            flagNewFacility = false;
                                                            continue AC;
                                                        default:
                                                            flagNewFacility = false;
                                                            System.out.println("Nhập Lại Ngoài Phạm Vi Truy Cập");
                                                            break;
                                                    }
                                                } while (flagNewFacility == false);
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                flagFacility = false;
                                                continue AD;
                                            default:
                                                flagFacility = false;
                                                System.out.println("Nhập Lại");
                                                break;
                                        }
                                    } while (!flagFacility);
                                } catch (Exception e) {
                                    e.printStackTrace();
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

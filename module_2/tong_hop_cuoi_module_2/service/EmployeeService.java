package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.repository.EmployeeRepository;
import tong_hop_cuoi_module_2.repository.IEmployeeRepository;
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
                System.out.println("Mời Nhập Mã Khách Hàng Mới (NV-XXXX , X là số từ 0-9)");
                id = scanner.nextLine();
                if (!Regex.checkID(id)) {
                    System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                }
            } while (!Regex.checkID(id));
            if (employeeRepository.checkID(id) == false) {
                System.out.println("Trùng Lặp ID Vui lòng Nhập Lại");
                flagCheck = false;
            } else {
                flagCheck = true;
            }
        } while (flagCheck == false);
        String name;
        do {
            System.out.println("Mời Nhập Họ Và Tên Khách Hàng ( Chữ cái đầu của mỗi từ phải viết hoa)");
            name = scanner.nextLine();
            if (!Regex.checkName(name)) {
                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
            }
        } while (!Regex.checkName(name));
        String date;
        do {
            System.out.println("Nhập Ngày Tháng Năm Sinh :Trên 18+ (XX-YY-MMMM , XX: Ngày , YY : Tháng , MMMM : Năm , )");
            date = scanner.nextLine();
            if (!CheckYear.is18YearsOld(date)) {
                System.out.println("(Bạn Sai Định Dạng , Chưa Đủ 18+ ) Vui Lòng Nhập Lại");
            }
        } while (!CheckYear.is18YearsOld(date));
        String gender = null;
        boolean flag = true;
        do {
            flag = true;
            try {
                System.out.println("Mời Bạn Nhập Giới Tính Mới:" +
                        "\n1.Nam" +
                        "\n2.Nữ" +
                        "\n3.Khác");
                int checkGender = Integer.parseInt(scanner.nextLine());
                switch (checkGender) {
                    case 1:
                        gender = "Nam";
                        break;
                    case 2:
                        gender = "Nữ";
                        break;
                    case 3:
                        gender = " Khác";
                        break;
                    default:
                        flag = false;
                        System.out.println("Ngoài Phạm Vi Chức Năng Mời Bạn Nhập Lại");
                        break;
                }
            } catch (Exception e) {
                flag = false;
                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
            }
        } while (!flag);
        String numberName;
        do {
            System.out.println("Nhập Chính Minh Nhân Dân Mới(9 số - 12 số)");
            numberName = scanner.nextLine();
            if (!Regex.checkNumberName(numberName)) {
                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
            }
        } while (!Regex.checkNumberName(numberName));
        String numberPhone;
        do {
            System.out.println("Nhập Số Điện Thoại (Bắt đầu bằng 0, Đủ 10 số)");
            numberPhone = scanner.nextLine();
            if (!Regex.checkNumberPhone(numberPhone)) {
                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
            }
        } while (!Regex.checkNumberPhone(numberPhone));
        String email;
        do {
            System.out.println("Mời Nhập Địa chỉ Email mới ");
            email = scanner.nextLine();
            if (!Regex.checkEmail(email)) {
                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
            }
        } while (!Regex.checkEmail(email));
        String level = null;
        boolean flagLevel = true;
        do {
            flagLevel = true;
            try {
                System.out.println("Mời Nhập Trình Độ Học Vấn :" + "\n1.Trung cấp" + "\n2.Cao đẳng" + "\n3.Đại học" + "\n4.Sau đại học ");
                int check = Integer.parseInt(scanner.nextLine());
                switch (check) {
                    case 1:
                        level = "Trung Cấp";
                        break;
                    case 2:
                        level = "Cao Đẳng";
                        break;
                    case 3:
                        level = "Đại Học";
                        break;
                    case 4:
                        level = "Sau Đại Học";
                        break;
                    default:
                        flagLevel = false;
                        System.out.println("Ngoài Pham Vi Truy Cập");
                }
            } catch (Exception e) {
                flagLevel = false;
                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
            }
        } while (!flagLevel);
        String position = null;
        boolean flagPosition = true;
        do {
            flagPosition = true;
            try {
                System.out.println("Mời Nhập Vị TRí" + "\n1.Lễ Tân" + "\n2.Phục Vụ" + "\n3.Chuyên Viên" + "\n4.Giám Sát" + "\n5.Quản Lí " + "\n6.Giám Đốc");
                int check = Integer.parseInt(scanner.nextLine());
                switch (check) {
                    case 1:
                        position = "Lễ Tân";
                        break;
                    case 2:
                        position = "Phục Vụ";
                        break;
                    case 3:
                        position = "Chuyên Viên";
                        break;
                    case 4:
                        position = "Giám Sát";
                        break;
                    case 5:
                        position = "Quản Lí";
                        break;
                    case 6:
                        position = "Giám Đốc";
                        break;
                    default:
                        flagPosition = false;
                        System.out.println("Ngoài Pham Vi Truy Cập");
                }
            } catch (Exception e) {
                flagPosition = false;
                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
            }
        } while (!flagPosition);
        long wage = 0;
        boolean flagWage = true;
        do {
            try {
                System.out.println("Mời Nhập Mức Lương");
                wage = Long.parseLong(scanner.nextLine());
                if (wage > 0) {
                    flagWage = false;
                }
            } catch (Exception ex) {
                System.out.println("Sai Kiểu Dữ Liệu Vui Lòng Nhập Lại");
            }
        } while (flagWage);
        Employee employee = new Employee(id, name, date, gender, numberName, numberPhone, email, level, position, wage);
        employeeRepository.add(employee);

    }

    @Override
    public void fix() {
        Scanner scanner = new Scanner(System.in);
        boolean flagCheck = false;
        String id;
        do {
            System.out.println("Mời Bạn Nhập ID Bạn muốn sửa (NV-XXXX , X : Là số 0-9)");
            id = scanner.nextLine();
            if (employeeRepository.checkID(id) == false) {
                flagCheck = false;
            } else {
                System.out.println("(ID Không Tồn Tại , Sai Định Dạng) Mời Bạn Nhập Lại ");
                flagCheck = true;
            }
        } while (flagCheck);
        boolean flagOne = true;
        do {
            flagOne = true;
            try {
                System.out.println("Mời Bạn Chọn :" + "\n1.Mã Nhân Viên " + "\n2.Tên Nhân Viên" + "\n3.Ngày Tháng Năm Sinh" + "\n4.Giới Tính" + "\n5.Số Chính Minh Nhân Dân" + "\n6.Số Điện Thoại" + "\n7.Email" + "\n8.Trình Độ Học Vấn" + "\n9.Vị Trí " + "\n10.Lương" + "\n11.Thoát");
                int check = Integer.parseInt(scanner.nextLine());
                switch (check) {
                    case 1:
                        String idFix;
                        boolean flagFix = false;
                        do {
                            do {
                                System.out.println("Mời Nhập Mã Khách Hàng Mới (NV-XXXX , X là số từ 0-9)");
                                idFix = scanner.nextLine();
                                if (!Regex.checkID(id)) {
                                    System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                                }
                            } while (!Regex.checkID(id));
                            if (employeeRepository.checkID(idFix) == false) {
                                System.out.println("Trùng Lặp ID Vui lòng Nhập Lại");
                                flagFix = false;
                            } else {
                                flagFix = true;
                            }
                        } while (flagFix == false);
                        employeeRepository.fix(id, 1, idFix);
                        break;
                    case 2:
                        String name;
                        do {
                            System.out.println("Mời Nhập Họ Và Tên Khách Hàng ( Chữ cái đầu của mỗi từ phải viết hoa)");
                            name = scanner.nextLine();
                            if (!Regex.checkName(name)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                        } while (!Regex.checkName(name));
                        break;
                    case 3:
                        String date;
                        do {
                            System.out.println("Nhập Ngày Tháng Năm Sinh :Trên 18+ (XX-YY-MMMM , XX: Ngày , YY : Tháng , MMMM : Năm , )");
                            date = scanner.nextLine();
                            if (!CheckYear.is18YearsOld(date)) {
                                System.out.println("(Bạn Sai Định Dạng , Chưa Đủ 18+ ) Vui Lòng Nhập Lại");
                            }
                        } while (!CheckYear.is18YearsOld(date));
                        employeeRepository.fix(id, 3, date);
                        break;
                    case 4:
                        boolean flag = true;
                        do {
                            flag = true;
                            try {
                                System.out.println("Mời Bạn Nhập Giới Tính Mới:" +
                                        "\n1.Nam" +
                                        "\n2.Nữ" +
                                        "\n3.Khác");
                                int checkGender = Integer.parseInt(scanner.nextLine());
                                switch (checkGender) {
                                    case 1:
                                        employeeRepository.fix(id, 4, "Nam");
                                        break;
                                    case 2:
                                        employeeRepository.fix(id, 4, "Nữ");
                                        break;
                                    case 3:
                                        employeeRepository.fix(id, 4, "Khác");
                                        break;
                                    default:
                                        flag = false;
                                        System.out.println("Ngoài Phạm Vi Chức Năng Mời Bạn Nhập Lại");
                                        break;
                                }
                            } catch (Exception e) {
                                flag = false;
                                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
                            }
                        } while (!flag);
                        break;
                    case 5:
                        String numberName;
                        do {
                            System.out.println("Nhập Chính Minh Nhân Dân Mới(9 số - 12 số)");
                            numberName = scanner.nextLine();
                            if (!Regex.checkNumberName(numberName)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                        } while (!Regex.checkNumberName(numberName));
                        employeeRepository.fix(id, 5, numberName);
                        break;
                    case 6:
                        String numberPhone;
                        do {
                            System.out.println("Nhập Số Điện Thoại (Bắt đầu bằng 0, Đủ 10 số)");
                            numberPhone = scanner.nextLine();
                            if (!Regex.checkNumberPhone(numberPhone)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                        } while (!Regex.checkNumberPhone(numberPhone));
                        employeeRepository.fix(id, 6, numberPhone);
                        break;
                    case 7:
                        String email;
                        do {
                            System.out.println("Mời Nhập Địa chỉ Email mới ");
                            email = scanner.nextLine();
                            if (!Regex.checkEmail(email)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                        } while (!Regex.checkEmail(email));
                        employeeRepository.fix(id, 7, email);
                        break;
                    case 8:
                        String level = null;
                        boolean flagLevel = true;
                        do {
                            flagLevel = true;
                            try {
                                System.out.println("Mời Nhập Trình Độ Học Vấn :" + "\n1.Trung cấp" + "\n2.Cao đẳng" + "\n3.Đại học" + "\n4.Sau đại học ");
                                int checkLevel = Integer.parseInt(scanner.nextLine());
                                switch (checkLevel) {
                                    case 1:
                                        level = "Trung Cấp";
                                        break;
                                    case 2:
                                        level = "Cao Đẳng";
                                        break;
                                    case 3:
                                        level = "Đại Học";
                                        break;
                                    case 4:
                                        level = "Sau Đại Học";
                                        break;
                                    default:
                                        flagLevel = false;
                                        System.out.println("Ngoài Pham Vi Truy Cập");
                                }
                            } catch (Exception e) {
                                flagLevel = false;
                                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
                            }
                        } while (!flagLevel);
                        employeeRepository.fix(id, 8, level);
                        break;
                    case 9:
                        String position = null;
                        boolean flagPosition = true;
                        do {
                            flagPosition = true;
                            try {
                                System.out.println("Mời Nhập Vị TRí" + "\n1.Lễ Tân" + "\n2.Phục Vụ" + "\n3.Chuyên Viên" + "\n4.Giám Sát" + "\n5.Quản Lí " + "\n6.Giám Đốc");
                                int checkPosition = Integer.parseInt(scanner.nextLine());
                                switch (checkPosition) {
                                    case 1:
                                        position = "Lễ Tân";
                                        break;
                                    case 2:
                                        position = "Phục Vụ";
                                        break;
                                    case 3:
                                        position = "Chuyên Viên";
                                        break;
                                    case 4:
                                        position = "Giám Sát";
                                        break;
                                    case 5:
                                        position = "Quản Lí";
                                        break;
                                    case 6:
                                        position = "Giám Đốc";
                                        break;
                                    default:
                                        flagPosition = false;
                                        System.out.println("Ngoài Pham Vi Truy Cập");
                                }
                            } catch (Exception e) {
                                flagPosition = false;
                                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
                            }
                        } while (!flagPosition);
                        employeeRepository.fix(id, 9, position);
                        break;
                    case 10:
                        long wage = 0;
                        boolean flagWage = true;
                        do {
                            try {
                                System.out.println("Mời Nhập Mức Lương");
                                wage = Long.parseLong(scanner.nextLine());
                                if (wage > 0) {
                                    flagWage = false;
                                }
                            } catch (Exception ex) {
                                System.out.println("Sai Kiểu Dữ Liệu Vui Lòng Nhập Lại");
                            }
                        } while (flagWage);
                        employeeRepository.fix(id,10, String.valueOf(wage));
                        break;
                    case 11:
                        System.out.println("Cập Nhật Thành Công");
                        flagOne = false;
                        break;
                    default:
                        System.out.println("Ngoài Phạm Vi Truy Cập Vui Lòng Nhập Lại");
                        break;
                }


            } catch (Exception ex) {
                flagOne = true;
                System.out.println("Sai Kiểu Dữ Liệu Mời Nhập Lại");
            }
        } while (flagOne);

    }


}

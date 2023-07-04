package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.repository.CustomerRepository;
import tong_hop_cuoi_module_2.repository.ICustomerRepository;
import tong_hop_cuoi_module_2.util.*;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();


    @Override
    public List<Customer> display() {
        List<Customer> list = customerRepository.display();
        for (Customer pr : list) {
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
                System.out.println("Mời Nhập Mã Khách Hàng Mới (KH-XXXX , X là số từ 0-9)");
                id = scanner.nextLine();
                if (!Regex.checkIDOne(id)) {
                    System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                }
            } while (!Regex.checkIDOne(id));
            if (customerRepository.checkID(id) == false) {
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
        String typeOfGuest = null;
        boolean flagTypeOfGuest = true;
        do {
            flagTypeOfGuest = true;
            try {
                System.out.println("Mời Nhập Hạng Khách Hàng" + "\n1.Diamond" + "\n2.Platinum" + "\n3.Gold" + "\n4.Silver" + "\n5.Member ");
                int check = Integer.parseInt(scanner.nextLine());
                switch (check) {
                    case 1:
                        typeOfGuest = "Diamond";
                        break;
                    case 2:
                        typeOfGuest = "Platinum";
                        break;
                    case 3:
                        typeOfGuest = "Gold";
                        break;
                    case 4:
                        typeOfGuest = "Silver";
                        break;
                    case 5:
                        typeOfGuest = "Member";
                        break;
                    default:
                        flagTypeOfGuest = false;
                        System.out.println("Ngoài Pham Vi Truy Cập");
                }
            } catch (Exception e) {
                flagTypeOfGuest = false;
                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
            }
        } while (!flagTypeOfGuest);
        String address;
        do {
            System.out.println("Mời Nhập Địa Chỉ Khách Hàng(00-Nguyen Du - Da Nang) ");
            address = scanner.nextLine();
            if (!Regex.checkAddress(address)) {
                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
            }
        } while (!Regex.checkAddress(address));
        System.out.println("Thêm Thông Tin Thành Công");
        Customer customer = new Customer(id, name, date, gender, numberName, numberPhone, email, typeOfGuest, address);
        customerRepository.add(customer);

    }

    @Override
    public void fix() {
        Scanner scanner = new Scanner(System.in);
        boolean flagCheck = false;
        String id;
        do {
            System.out.println("Mời Bạn Nhập ID Bạn muốn sửa (KH-XXXX , X : Là số 0-9)");
            id = scanner.nextLine();
            if (customerRepository.checkID(id) == false) {
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
                System.out.println("Mời Bạn Chọn :" + "\n1.Mã Khách Hàng " + "\n2.Tên Khách Hàng" + "\n3.Ngày Tháng Năm Sinh" + "\n4.Giới Tính" + "\n5.Số Chính Minh Nhân Dân" + "\n6.Số Điện Thoại" + "\n7.Email" + "\n8.Hạng Khách" + "\n9.Địa Chỉ " + "\n10.Thoát");
                int check = Integer.parseInt(scanner.nextLine());
                switch (check) {
                    case 1:
                        String idFix;
                        boolean flagFix = false;
                        do {
                            do {
                                System.out.println("Mời Nhập Mã Khách Hàng Mới (KH-XXXX , X là số từ 0-9)");
                                idFix = scanner.nextLine();
                                if (!Regex.checkIDOne(id)) {
                                    System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                                }
                            } while (!Regex.checkIDOne(id));
                            if (customerRepository.checkID(idFix) == false) {
                                System.out.println("Trùng Lặp ID Vui lòng Nhập Lại");
                                flagFix = false;
                            } else {
                                flagFix = true;
                            }
                        } while (flagFix == false);
                        customerRepository.fix(id, 1, idFix);
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
                        customerRepository.fix(id, 3, date);
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
                                        customerRepository.fix(id, 4, "Nam");
                                        break;
                                    case 2:
                                        customerRepository.fix(id, 4, "Nữ");
                                        break;
                                    case 3:
                                        customerRepository.fix(id, 4, "Khác");
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
                        customerRepository.fix(id, 5, numberName);
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
                        customerRepository.fix(id, 6, numberPhone);
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
                        customerRepository.fix(id, 7, email);
                        break;
                    case 8:
                        String typeOfGuest = null;
                        boolean flagTypeOfGuest = true;
                        do {
                            flagTypeOfGuest = true;
                            try {
                                System.out.println("Mời Nhập Hạng Khách Hàng" + "\n1.Diamond" + "\n2.Platinum" + "\n3.Gold" + "\n4.Silver" + "\n5.Member ");
                                int checkTypeOfGuest = Integer.parseInt(scanner.nextLine());
                                switch (checkTypeOfGuest) {
                                    case 1:
                                        typeOfGuest = "Diamond";
                                        break;
                                    case 2:
                                        typeOfGuest = "Platinum";
                                        break;
                                    case 3:
                                        typeOfGuest = "Gold";
                                        break;
                                    case 4:
                                        typeOfGuest = "Silver";
                                        break;
                                    case 5:
                                        typeOfGuest = "Member";
                                        break;
                                    default:
                                        flagTypeOfGuest = false;
                                        System.out.println("Ngoài Pham Vi Truy Cập");
                                }
                            } catch (Exception e) {
                                flagTypeOfGuest = false;
                                System.out.println("Lỗi Kiểu Dữ Liệu Mời Bạn Nhập Lại");
                            }
                        } while (!flagTypeOfGuest);
                        customerRepository.fix(id, 8, typeOfGuest);
                        break;
                    case 9:
                        String address;
                        do {
                            System.out.println("Mời Nhập Địa Chỉ Khách Hàng(00-Nguyen Du - Da Nang) ");
                            address = scanner.nextLine();
                            if (!Regex.checkAddress(address)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                        } while (!Regex.checkAddress(address));
                        customerRepository.fix(id, 9, address);
                        break;
                    case 10:
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

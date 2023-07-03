package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.model.Employee;
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
            } while (!Regex.checkIDOne(id));
            if (customerRepository.checkID(id) == false) {
                flagCheck = false;
            } else {
                flagCheck = true;
            }
        } while (flagCheck == false);
        String name;
        do {
            System.out.println("Mời Nhập Họ Và Tên Khách Hàng ( Chữ cái đầu của mỗi từ phải viết hoa)");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        String date;
        do {
            System.out.println("Nhập Ngày Tháng Năm Sinh :Trên 18+ (XX-YY-MMMM , XX: Ngày , YY : Tháng , MMMM : Năm , )");
            date = scanner.nextLine();
        } while (!CheckYear.is18YearsOld(date));
        System.out.println("Nhập Giới Tính");
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
            System.out.println("Mời Nhập Địa chỉ Email mới ");
            email = scanner.nextLine();
        } while (!Regex.checkEmail(email));
        String typeOfGuest;
        do {
            System.out.println("Mời Nhập Hạng Khách Hàng ");
            typeOfGuest = scanner.nextLine();
        } while (!CheckTypeOfGuest.checkTypeOfGuest(typeOfGuest));
        String address;
        do {
            System.out.println("Mời Nhập Địa Chỉ Khách Hàng(00-Nguyen Du - Da Nang) ");
            address = scanner.nextLine();
        } while (!CheckPosition.checkPosition(address));
        Customer customer = new Customer(id, name, date, gender, numberName, numberPhone, email, typeOfGuest, address);
        customerRepository.add(customer);

    }

    @Override
    public void fix() {
        Scanner scanner = new Scanner(System.in);
        boolean flagCheck = false;
        String id;
        do {
            System.out.println("Mời Bạn Nhập ID Bạn muốn sửa");
            id = scanner.nextLine();
            if (customerRepository.checkID(id) == true) {
                flagCheck = false;
            } else {
                flagCheck = true;
            }
        } while (flagCheck == false);
        boolean flag = true;
        do {
            System.out.println("Bạn có chắc chắn Không" +
                    "\n1.Yes" +
                    "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flag = false;
                    customerRepository.fix(id);
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Mời Bạn Nhập Lai Ngoài Phạm Vi Truy Cập");
                    break;
            }
        } while (flag);

    }

}

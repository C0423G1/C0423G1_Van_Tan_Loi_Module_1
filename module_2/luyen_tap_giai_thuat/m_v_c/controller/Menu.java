package luyen_tap_giai_thuat.m_v_c.controller;

import luyen_tap_giai_thuat.m_v_c.service.Vehicle;

import java.util.Scanner;

public class Menu {
    public static Vehicle vehicle = new Vehicle();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------ Bắt Đầu Chương Trình--------------------------");
        boolean flag = true;
        do {
            try {
                System.out.println("1.Tạo Các đối tượng xe và nhập thông tin" + "\n2.Xuất bảng kê khai tiền thuế của các xe" + "\n3.Thoát");
                int a = Integer.parseInt(scanner.nextLine());
                switch (a) {
                    case 1:
                        vehicle.add();
                        break;
                    case 2:
                        vehicle.display();
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        System.out.println("Ngoài phạm vi truy cập vui lòng nhập lại");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Sai Kiểu Dữ Liệu vui Lòng Nhập lại");
            }
        } while (flag);
    }
}

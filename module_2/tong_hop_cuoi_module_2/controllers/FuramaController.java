package tong_hop_cuoi_module_2.controllers;

import java.util.Scanner;

public class FuramaController {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------- Bắt Đầu Chương Trình ---------------------------------------");
        System.out.println("1. Employee Management" +
                "\n2. Customer Management" +
                "\n3. Facility Management" +
                "\n4. Booking Management" +
                "\n5. Promotion Management" +
                "\n6. Exit");
        boolean flag = true;
        do {
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
                                    System.out.println("1 Display list employees" +
                                            "\n2 Add new employee" +
                                            "\n3 Edit employee" +
                                            "\n4 Return main menu");
                                    int menuOne = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 2:
                            do {
                                flagCheck = true;
                                try {
                                    System.out.println("-----------------   Customer Management --------------- ");
                                    System.out.println("1. Display list customers" +
                                            "\n2. Add new customer" +
                                            "\n3. Edit customer" +
                                            "\n4. Return main menu");
                                    int menuTwo = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 3:
                            do {
                                System.out.println("-----------------   Facility Management --------------- ");
                                System.out.println("1 Display list facility" +
                                        "\n2 Add new facility" +
                                        "\n3 Display list facility maintenance" +
                                        "\n4 Return main menu");
                                flagCheck = true;
                                try {
                                    int menuThree = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 4:
                            do {
                                System.out.println("-----------------   Booking Management --------------- ");
                                System.out.println("1. Add new booking" +
                                        "\n2. Display list booking" +
                                        "\n3. Create new contracts" +
                                        "\n4. Display list contracts" +
                                        "\n5. Edit contracts" +
                                        "\n6. Return main menu");
                                flagCheck = true;
                                try {
                                    int menuFour = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type");
                                    flagCheck = false;
                                }
                            } while (flagCheck == false);
                            break;
                        case 5:
                            do {
                                System.out.println("----------------- Promotion Management --------------- ");
                                System.out.println("1. Display list customers use service" +
                                        "\n2. Display list customers get voucher" +
                                        "\n3. Return main menu");
                                flagCheck = true;
                                try {
                                    int menuFive = Integer.parseInt(scanner.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Error : Wrong Data Type");
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
                    System.out.println("Error : Wrong Data Type");
                    flagCheck = false;
                }
            } while (flagCheck == false);

        } while (flag == false);
    }
}

package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.model.Employee;
import tong_hop_cuoi_module_2.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository implements ICustomerRepository {

    public void add(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv");
        customers.add(customer);
        WriteAndRead.writeOne(customers, "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv", false);
    }


    @Override
    public void fix(String id) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv");
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setName(name);
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setDate(date);
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setGender(gender);
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setNumberName(numberName);
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setNumberPhone(numberPhone);
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
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setEmail(email);
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
        boolean flagTypeOfGuest = true;
        do {
            String typeOfGuest;
            do {
                System.out.println("Do you want to change your TypeOfGuest gồm: (Diamond, Platinum, Gold, Silver, Member).");
                typeOfGuest = scanner.nextLine();
            } while (!CheckLevel.checkLevel(typeOfGuest));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagTypeOfGuest = false;
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setTypeOfGuest(typeOfGuest);
                        }
                    }
                    break;
                case 2:
                    flagTypeOfGuest = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagTypeOfGuest);
        boolean flagAddress = true;
        do {
            String address;
            do {
                System.out.println("Do you want to change your Position( 00,Nguyen Du,Da Nang) ");
                address = scanner.nextLine();
            } while (!CheckPosition.checkPosition(address));
            System.out.println("Are you sure" + "\n1.Yes" + "\n2.No");
            int check = Integer.parseInt(scanner.nextLine());
            switch (check) {
                case 1:
                    flagAddress = false;
                    for (int i = 0; i < customers.size(); i++) {
                        if (id.equals(customers.get(i).getId())) {
                            customers.get(i).setAddress(address);
                        }
                    }
                    break;
                case 2:
                    flagAddress = false;
                    break;
                default:
                    System.out.println("Nothingness! retype");
                    break;
            }
        } while (flagAddress);
        WriteAndRead.writeOne(customers, "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Employee.csv", false);

    }

    @Override
    public List<Customer> display() {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv");
        return customers;
    }

    @Override
    public boolean checkID(String id) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv");
        for (int i = 0; i < customers.size(); i++) {
            if (id.equals(customers.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
}

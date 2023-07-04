package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.util.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    public static final String FILE_CUSTOMER =  "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Customer.csv";

    public void add(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne(FILE_CUSTOMER);
        customers.add(customer);
        WriteAndRead.writeOne(customers, FILE_CUSTOMER, false);
    }


    @Override
    public void fix(String id, int number, String function) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne(FILE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (id.equals(customers.get(i).getId())) {
                switch (number) {
                    case 1:
                        customers.get(i).setId(function);
                        break;
                    case 2:
                        customers.get(i).setName(function);
                        break;
                    case 3:
                        customers.get(i).setDate(function);
                        break;
                    case 4:
                        customers.get(i).setGender(function);
                        break;
                    case 5:
                        customers.get(i).setNumberName(function);
                        break;
                    case 6:
                        customers.get(i).setNumberName(function);
                        break;
                    case 7:
                        customers.get(i).setEmail(function);
                        break;
                    case 8:
                        customers.get(i).setTypeOfGuest(function);
                        break;
                    case 9:
                        customers.get(i).setAddress(function);
                        break;
                }
            }
        }
        WriteAndRead.writeOne(customers, FILE_CUSTOMER, false);
    }

    @Override
    public List<Customer> display() {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne(FILE_CUSTOMER);
        return customers;
    }

    @Override
    public boolean checkID(String id) {
        List<Customer> customers = new ArrayList<>();
        customers = WriteAndRead.readOne(FILE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (id.equals(customers.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
}

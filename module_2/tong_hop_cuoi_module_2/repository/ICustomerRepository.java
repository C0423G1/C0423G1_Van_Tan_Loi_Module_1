package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.model.Employee;

import java.util.List;

public interface ICustomerRepository {
    void add(Customer customer);

    void fix(String id,int a, String function);

    List<Customer> display();
    boolean checkID(String id);


}

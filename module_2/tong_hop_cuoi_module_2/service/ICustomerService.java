package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Customer;
import tong_hop_cuoi_module_2.model.Employee;

import java.util.List;

public interface ICustomerService extends Service {

    List<Customer> display();

    void add();

    void fix();
}

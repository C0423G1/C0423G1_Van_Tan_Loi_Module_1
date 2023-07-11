package luyen_tap_giai_thuat.m_v_c.service;

import luyen_tap_giai_thuat.m_v_c.repository.IVehicleRepository;
import luyen_tap_giai_thuat.m_v_c.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle implements IVehicleService {
    IVehicleRepository vehicleRepository = new VehicleRepository();

    @Override
    public void display() {
        ArrayList<luyen_tap_giai_thuat.m_v_c.model.Vehicle> vehicles = vehicleRepository.display();
        for (luyen_tap_giai_thuat.m_v_c.model.Vehicle s : vehicles) {
            System.out.println(s);
        }
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID :");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Tên Xe");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá tiền xe");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Dung tích xe");
        int capacity = Integer.parseInt(scanner.nextLine());
        vehicleRepository.add(new luyen_tap_giai_thuat.m_v_c.model.Vehicle(id, name, price, capacity));

    }
}

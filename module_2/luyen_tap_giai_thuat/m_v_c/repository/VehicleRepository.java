package luyen_tap_giai_thuat.m_v_c.repository;

import luyen_tap_giai_thuat.m_v_c.model.Vehicle;
import luyen_tap_giai_thuat.m_v_c.util.WriteAndRead;

import java.util.ArrayList;

public class VehicleRepository implements IVehicleRepository {

    public static final String FILE_VEHICLE = "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\luyen_tap_giai_thuat\\m_v_c\\data\\vehicle.csv";

    @Override
    public void add(Vehicle vehicle) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles = WriteAndRead.read(FILE_VEHICLE);
        vehicles.add(vehicle);
        WriteAndRead.write(FILE_VEHICLE, vehicles, false);
    }

    @Override
    public ArrayList<Vehicle> display() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles = WriteAndRead.read(FILE_VEHICLE);
        return vehicles;
    }
}

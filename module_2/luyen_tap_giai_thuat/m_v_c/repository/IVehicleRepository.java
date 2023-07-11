package luyen_tap_giai_thuat.m_v_c.repository;

import luyen_tap_giai_thuat.m_v_c.model.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepository {
    final int YEAR = 0;
     public abstract  void add(Vehicle vehicle);

    ArrayList<Vehicle> display();

}

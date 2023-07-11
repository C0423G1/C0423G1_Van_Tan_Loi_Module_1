package luyen_tap_giai_thuat.m_v_c.util;

import luyen_tap_giai_thuat.m_v_c.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class WriteAndRead {
    public static void write(String file, ArrayList<Vehicle> vehicle, boolean append) {
        try {
            FileWriter fr = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fr);
            for (Vehicle s : vehicle) {
                bw.write(s.toStringFile());
                bw.newLine();
            }
           bw.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Vehicle> read(String file) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] test = line.split(",");
                int id = Integer.parseInt(test[0]);
                String name = test[1];
                double price = Double.parseDouble(test[2]);
                int capacity = Integer.parseInt(test[3]);
                vehicles.add(new Vehicle(id, name, price, capacity));
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}

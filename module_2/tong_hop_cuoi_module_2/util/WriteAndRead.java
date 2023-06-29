package tong_hop_cuoi_module_2.util;

import tong_hop_cuoi_module_2.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndRead {
    public static List<Object> readBinary(String file) {
        List<Object> objects = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    public static void writeBinary(List<Employee> employees, String file) {
        try {
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(employees);
            oo.close();
            fo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(List<Employee> employees, String file, boolean append) {
        try {
            FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee e : employees) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> read(String file) {
        List<Employee> employees = new ArrayList<>();
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
                String id = test[0];
                String name = test[1];
                String date = test[2];
                String gender = test[3];
                String numberName = test[4];
                String numberPhone = test[5];
                String email = test[6];
                String level = test[7];
                String position = test[8];
                int wage = Integer.parseInt(test[9]);
                employees.add(new Employee(id, name, date, gender, numberName, numberPhone, email, level, position, wage));
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return employees;
    }
}

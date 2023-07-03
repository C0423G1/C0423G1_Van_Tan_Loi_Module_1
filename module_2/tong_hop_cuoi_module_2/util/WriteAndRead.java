package tong_hop_cuoi_module_2.util;

import tong_hop_cuoi_module_2.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
                } else {
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

    public static void writeOne(List<Customer> customers, String file, boolean append) {
        try {
            FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Customer e : customers) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> readOne(String file) {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] tests = line.split(",");
                    String id = tests[0];
                    String name = tests[1];
                    String date = tests[2];
                    String gender = tests[3];
                    String numberName = tests[4];
                    String numberPhone = tests[5];
                    String email = tests[6];
                    String typeOfGuest = tests[7];
                    String address = tests[8];
                    customers.add(new Customer(id, name, date, gender, numberName, numberPhone, email, typeOfGuest, address));
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return customers;
    }

    public static LinkedHashMap<Facility, Integer> readVilla(String file) {
        LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] tests = line.split(",");
                    String id = tests[0];
                    String name = tests[1];
                    double acreage = Double.parseDouble(tests[2]);
                    double expense = Double.parseDouble(tests[3]);
                    int quantity = Integer.parseInt(tests[4]);
                    String date = tests[5];
                    String roomStandard = tests[6];
                    double poolArea = Double.parseDouble(tests[7]);
                    int floors = Integer.parseInt(tests[8]);
                    Integer value = Integer.parseInt(tests[9]);
                    linkedHashMap.put(new Villa(id, name, acreage, expense, quantity, date, roomStandard, poolArea, floors), value);
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return linkedHashMap;
    }

    public static void writeVilla(LinkedHashMap<Facility, Integer> facilityIntegerLinkedHashMap, String file, boolean append) {
        try {
            FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<Facility, Integer> e : facilityIntegerLinkedHashMap.entrySet()) {
                bw.write(e.getKey() + "," + e.getValue());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LinkedHashMap<Facility, Integer> readRoom(String file) {
        LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] tests = line.split(",");
                    String id = tests[0];
                    String name = tests[1];
                    double acreage = Double.parseDouble(tests[2]);
                    double expense = Double.parseDouble(tests[3]);
                    int quantity = Integer.parseInt(tests[4]);
                    String date = tests[5];
                    String freeService = tests[6];
                    Integer value = Integer.parseInt(tests[7]);
                    linkedHashMap.put(new Room(id, name, acreage, expense, quantity, date, freeService), value);
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return linkedHashMap;
    }

    public static LinkedHashMap<Facility, Integer> readHouse(String file) {
        LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] tests = line.split(",");
                    String id = tests[0];
                    String name = tests[1];
                    double acreage = Double.parseDouble(tests[2]);
                    double expense = Double.parseDouble(tests[3]);
                    int quantity = Integer.parseInt(tests[4]);
                    String date = tests[5];
                    String roomStandard = tests[6];
                    int floors = Integer.parseInt(tests[7]);
                    Integer value = Integer.parseInt(tests[8]);
                    linkedHashMap.put(new House(id, name, acreage, expense, quantity, date, roomStandard, floors), value);
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return linkedHashMap;
    }

}

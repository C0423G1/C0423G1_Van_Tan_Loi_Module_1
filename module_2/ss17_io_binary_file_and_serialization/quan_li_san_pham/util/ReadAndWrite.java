package ss17_io_binary_file_and_serialization.quan_li_san_pham.util;

import ss16_text_file.Nation;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.model.ProductManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeProductBinary(List<ProductManagement> productManagements, boolean append) {
        try {
            FileOutputStream f = new FileOutputStream("ss17_io_binary_file_and_serialization/quan_li_san_pham/data/Product.dat", append);
            ObjectOutputStream ob = new ObjectOutputStream(f);
            ob.writeObject(productManagements);
            ob.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Lỗi 1");
        }
    }

    public static void writeProduct(List<ProductManagement> productManagements, boolean append) {
        try {
            FileWriter fw = new FileWriter("ss17_io_binary_file_and_serialization/quan_li_san_pham/data/Product.csv", append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (ProductManagement s : productManagements) {
                bw.write(s.toStringOne());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Lỗi 2");
        }
    }

    public static List<ProductManagement> readProductBinary() {
        List<ProductManagement> list = new ArrayList<>();
        try {
            FileInputStream fl = new FileInputStream("ss17_io_binary_file_and_serialization/quan_li_san_pham/data/Product.dat");
            ObjectInputStream ob = new ObjectInputStream(fl);
            ob.readObject();
            ob.close();
            fl.close();
        } catch (Exception ex) {
            System.out.println("Lỗi 3");
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public static List<ProductManagement> readProduct() {
        List<ProductManagement> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\ss17_io_binary_file_and_serialization\\quan_li_san_pham\\data\\Product.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String test[] = line.split(",");
                int id = Integer.parseInt(test[0]);
                String name = test[1];
                double price = Double.parseDouble(test[2]);
                String manufacture = test[3];
                String describe = test[4];
                list.add(new ProductManagement(id, name, price, manufacture, describe));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            System.out.println("lỗi 4");
            ex.printStackTrace();
        }
        return list;
    }

    public static void copyFile() {
        List<ProductManagement> list = new ArrayList<>();
        try {
            FileInputStream fl = new FileInputStream("ss17_io_binary_file_and_serialization/quan_li_san_pham/data/Product.dat");
            ObjectInputStream ob = new ObjectInputStream(fl);
            list= (List<ProductManagement>) ob.readObject();
            ob.close();
            fl.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            FileOutputStream f = new FileOutputStream("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\ss17_io_binary_file_and_serialization\\quan_li_san_pham\\data\\ProductCopy.dat");
            ObjectOutputStream ob = new ObjectOutputStream(f);
            ob.writeObject(list);
            ob.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Lỗi 1");
        }
    }

}

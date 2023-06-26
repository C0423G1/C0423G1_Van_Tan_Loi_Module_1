package ss17_io_binary_file_and_serialization.quan_li_san_pham.repository;

import m_v_c_tong_hop.util.ReadStudentTeacher;
import ss16_text_file.ReadText;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.model.ProductManagement;
import ss17_io_binary_file_and_serialization.quan_li_san_pham.util.ReadAndWrite;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static public List<ProductManagement> managements = new ArrayList<>();

    static {
        managements.add(new ProductManagement(123, "Bút Chì", 1000, "Việt Nam", "Để Viết"));
        managements.add(new ProductManagement(124, "Bút Mực", 5000, "Việt Nam", "Để Viết"));
        managements.add(new ProductManagement(133, "Sách", 10000, "Việt Nam", "Để Đọc"));
    }


    public void add(ProductManagement productManagement) {
        managements.add(productManagement);
        ReadAndWrite.writeProduct(managements, false);
        ReadAndWrite.writeProductBinary(managements, false);
        ReadAndWrite.copyFile();


    }


    public List<ProductManagement> display() {
        managements = ReadAndWrite.readProduct();
        ReadAndWrite.readProductBinary();
        ReadAndWrite.copyFile();
        return managements;
    }


    public void Search(int id) {
        boolean flag = false;
        for (int i = 0; i < managements.size(); i++) {
            if (id == managements.get(i).getId()) {
                flag = true;
                System.out.println(managements.get(i));
                break;
            }
        }
        if (flag == false) {
            System.out.println("ID Bạn Tìm Không Tồn Tại Vui Lòng Nhập Lại");
        }
    }
}

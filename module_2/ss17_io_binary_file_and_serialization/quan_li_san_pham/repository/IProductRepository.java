package ss17_io_binary_file_and_serialization.quan_li_san_pham.repository;

import ss17_io_binary_file_and_serialization.quan_li_san_pham.model.ProductManagement;

import java.util.List;

public  interface IProductRepository {
     void  add(ProductManagement productManagement);

     List<ProductManagement> display();

     void Search(int id);
}

package ss12_java_collection_framework.mvc.repository;


import ss12_java_collection_framework.mvc.model.ProductModel;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductRepository implements IProductRepository {
    static public ArrayList<ProductModel> product = new ArrayList<>();

    static {
        product.add(new ProductModel(1, "Sách Phương Nam"));
        product.add(new ProductModel(2, "Truyện Tranh"));
        product.add(new ProductModel(6, "Sách Phương Nam"));
        product.add(new ProductModel(9, "Truyện Tranh"));
        product.add(new ProductModel(5, "Sách Phương Nam"));
        product.add(new ProductModel(7, "Truyện Tranh"));
    }


    @Override
    public void add(ProductModel productModel) {
        product.add(productModel);
    }

    @Override
    public ArrayList<ProductModel> display() {
        return product;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < product.size(); i++) {
            if (id == product.get(i).getId()) {
                product.remove(i);
            }
        }
    }

    @Override
    public void edit(int id) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < product.size(); i++) {
            if (id == product.get(i).getId()) {
                System.out.println("Mời bạn nhập Tên Sách Bạn muốn sửa");
                String nameBook = scanner.nextLine();
                product.get(i).setName(nameBook);
            }
        }
    }

    @Override
    public void arrange() {
        for (int j = 0; j < product.size(); j++) {
            for (int i = 0; i > product.size() - 1; i++) {
                if (product.get(i).getId() < product.get(i + 1).getId()) {
                    ProductModel check = new ProductModel(product.get(i).getId(), product.get(i).getName());
                    product.get(i).setId(product.get(i + 1).getId());
                    product.get(i).setName(product.get(i + 1).getName());
                    product.get(i + 1).setId(check.getId());
                    product.get(i + 1).setName(check.getName());
                }
            }
        }
    }
}

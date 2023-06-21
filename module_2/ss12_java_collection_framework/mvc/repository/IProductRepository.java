package ss12_java_collection_framework.mvc.repository;


import ss12_java_collection_framework.mvc.model.ProductModel;

import java.util.ArrayList;

public interface IProductRepository {
    void add(ProductModel productModel);

    ArrayList<ProductModel> display();

    void delete(int id);

    void arrange();

    void edit(int id);

}

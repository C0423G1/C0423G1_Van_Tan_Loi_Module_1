package ss17_io_binary_file_and_serialization.quan_li_san_pham.model;

import java.io.Serializable;

public class ProductManagement implements Serializable {
    private int id;
    public String name;
    private double price;

    private String manufacture;
    private String describe;

    public ProductManagement(int id, String name, double price, String manufacture, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
        this.describe = describe;
    }

    public ProductManagement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "ProductManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacture='" + manufacture + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String toStringOne() {
        return id + "," + name + "," + price + "," + manufacture + "," + describe;
    }
}

package ss12_java_collection_framework.mvc.model;

public class ProductModel {
    private int id;
    private String name;

    public ProductModel() {
    }

    public ProductModel(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

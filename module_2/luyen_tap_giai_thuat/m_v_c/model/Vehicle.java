package luyen_tap_giai_thuat.m_v_c.model;

public class Vehicle {
    private int id;
    private String name;
    private double price;
    private int capacity;

    public Vehicle(int id, String name, double price, int capacity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }

    public String toStringFile() {
        return id + "," + name + "," + price + "," + capacity;
    }
}

package ss6_ke_thua.bai_tap.circle_va_cylinder;

public class Cylinder extends Circle {
    public double height;
    public double volume;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double setVolume() {
        return height * radius * radius * 3.14;
    }

    @Override
    public String toString() {
        return "bán kính : " + radius + "màu sắc : " + color + "chiều cao : " + height;
    }
}

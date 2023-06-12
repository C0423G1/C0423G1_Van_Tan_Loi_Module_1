package ss6_ke_thua.bai_tap.circle_va_cylinder;

public class Circle {
    public double radius;
    public String color;
    public double acreage;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAcreage() {
        return radius * radius * 3.14;
    }

}

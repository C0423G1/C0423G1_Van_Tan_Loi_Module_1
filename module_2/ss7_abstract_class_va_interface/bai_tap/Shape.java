package ss7_abstract_class_va_interface.bai_tap;

public class Shape implements Resizeable {
    public String color = "Blue";
    public Boolean a = false;

    public Shape() {
    }

    public Shape(String color, Boolean a) {
        this.color = color;
        this.a = a;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Shape{" + "color='" + color + '\'' + ", filled=" + a + '}';
    }

    public void resize(double percent) {
    }
}
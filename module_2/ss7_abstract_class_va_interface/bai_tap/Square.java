package ss7_abstract_class_va_interface.bai_tap;

public class Square extends Shape implements Resizeable, Colorable {
    public double width = 1.0;

    public Square() {
    }


    public Square(double width) {
        this.width = width;
    }

    public Square(String color, Boolean a, double width) {
        super(color, a);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return width * 4;
    }

    @Override
    public String toString() {
        return "Square{" + "width=" + width + ", color='" + color + '\'' + ", a=" + a + '}';
    }

    @Override
    public void resize(double percent) {
        this.width += this.width * percent / 100;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

package ss7_abstract_class_va_interface.bai_tap;


import java.util.ArrayList;
import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.getArea());
        circle.resize(70);
        System.out.println(circle.getArea());
        Square square = new Square(10);
        System.out.println(square.getArea());
        square.resize(70);
//        square.howToColor();
        System.out.println(square.getArea());
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println(rectangle.getAcreage());
        rectangle.resize(70);
        System.out.println(rectangle.getAcreage());
        Shape[] shapes = new Shape[3];
        shapes[0] = rectangle;
        shapes[1] = square;
        shapes[2] = circle;
        for (Shape value : shapes) {
            value.resize(Math.floor(Math.random() * 99 + 1));
            if (value instanceof Colorable) {
                ((Colorable) value).howToColor();
            }
        }
        System.out.println(Arrays.toString(shapes));



    }
}

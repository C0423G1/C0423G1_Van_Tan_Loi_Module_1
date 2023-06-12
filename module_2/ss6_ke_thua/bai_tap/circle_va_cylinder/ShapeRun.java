package ss6_ke_thua.bai_tap.circle_va_cylinder;

import ss6_ke_thua.bai_tap.circle_va_cylinder.Circle;
import ss6_ke_thua.bai_tap.circle_va_cylinder.Cylinder;

public class ShapeRun {
    public static void main(String[] args) {
        Circle circle = new Circle(10, "blue");
        Cylinder cylinder = new Cylinder(5, "red", 10);
        System.out.println(circle.getAcreage());
        System.out.println(cylinder.setVolume());
    }
}

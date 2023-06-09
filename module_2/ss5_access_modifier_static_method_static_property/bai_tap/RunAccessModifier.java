package ss5_access_modifier_static_method_static_property.bai_tap;

import java.util.Scanner;

public class RunAccessModifier {
    public static void main(String[] args) {
        AccessModifier Circle = new AccessModifier();
        AccessModifier CircleOne = new AccessModifier(10);
        System.out.println(Circle.getRadius());
        System.out.println(Circle.getArea());
        System.out.println(CircleOne.getRadius());
        System.out.println(CircleOne.getArea());
    }
}

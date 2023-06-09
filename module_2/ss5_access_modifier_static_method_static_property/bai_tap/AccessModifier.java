package ss5_access_modifier_static_method_static_property.bai_tap;

public class AccessModifier {
    double radius = 1.0;
    String color = "red";

    AccessModifier() {
    }

    AccessModifier(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * 3.14;
    }
}


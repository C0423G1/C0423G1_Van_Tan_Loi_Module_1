package ss4_class_object.bai_tap;

public class Fan {
    int slow = 1;
    int medium = 2;
    int fast = 3;
    int speed = 1;
    boolean on = false;
    double radius = 5;
    String color = "blue";

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    public Fan() {
    }

    public String toString() {
        if (this.on) {
            return "Fan " +
                    "\noff = fan is off" +
                    "\n radius = " + radius +
                    " color = '" + color;

        } else {
            return "Fan" +
                    "\non = fan is on" +
                    "\n speed = " + speed +
                    "\n radius = " + radius +
                    "\n color = '" + color;
        }
    }
}


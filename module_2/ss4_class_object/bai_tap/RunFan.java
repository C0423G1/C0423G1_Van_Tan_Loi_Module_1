package ss4_class_object.bai_tap;

public class RunFan {
    public static void main(String[] args) {
        Fan fanOne = new Fan(3, false, 10, "yellow");
        System.out.println(fanOne.toString());
        Fan fanTwo = new Fan();
        System.out.println(fanTwo.toString());
    }
}

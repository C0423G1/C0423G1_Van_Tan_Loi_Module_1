package ss5_access_modifier_static_method_static_property.bai_tap;

public class RunStudent {
    public static void main(String[] args) {
        Student studentOne = new Student();
        studentOne.name = "Six";
        studentOne.classes = "C03";
        String name = studentOne.name;
        String classes = studentOne.classes;
        System.out.println("name :" + name);
        System.out.println("class :" + classes);
    }
}

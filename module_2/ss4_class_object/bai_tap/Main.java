package ss4_class_object.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập thứ a,b,b của phương trinh bậc hai : ax2 +bx +x = 0 ");
        System.out.println("Mời nhập a :");
        double a = sc.nextDouble();
        System.out.println("Mời nhập b :");
        double b = sc.nextDouble();
        System.out.println("Mời nhập c :");
        double c = sc.nextDouble();
        SquaredEquation equation = new SquaredEquation(a, b, c);
        System.out.println(equation.getDiscriminant());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println((-b + Math.sqrt(equation.getDiscriminant())) / (2 * a));
        if (equation.getA() == 0) {
            System.out.println("Mời bạn nhập lại phương trình");
        } else {
            if (equation.getDiscriminant() > 0) {
                System.out.println("Phương trình hai nghiệm phân biệt ");
                System.out.println("x1 = " + equation.getRoot1());
                System.out.println("x2 = " + equation.getRoot2());
            } else if (equation.getDiscriminant() == 0) {
                System.out.println("Phương trinh có một nghiệm");
                System.out.println("x1= x2 = " + equation.getRoot1());
            } else if (equation.getDiscriminant() < 0) {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}

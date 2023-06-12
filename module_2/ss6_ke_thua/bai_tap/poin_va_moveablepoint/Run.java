package ss6_ke_thua.bai_tap.poin_va_moveablepoint;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập x vào đây");
        int x = sc.nextInt();
        System.out.println("Nhập y vào đây");
        int y = sc.nextInt();
        System.out.println("Nhập xSpeed vào đây");
        int xSpeed = sc.nextInt();
        System.out.println("Nhập ySpeed vào đây");
        int ySpeed = sc.nextInt();
        Point point = new Point(x, y);
        MoveablePoint moveablePoint = new MoveablePoint(x, y, xSpeed, ySpeed);
        System.out.println(moveablePoint.toString());
        System.out.println(point.toString());
    }
}

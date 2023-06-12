package ss6_ke_thua.bai_tap.point_2d_3d;

import java.util.Scanner;

public class RunPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập x vào đây");
        int x = sc.nextInt();
        System.out.println("Nhập y vào đây");
        int y = sc.nextInt();
        System.out.println("Nhập z vào đây");
        int z = sc.nextInt();
        Point2D point2D = new Point2D(x, y);
        Point3D point3D = new Point3D(x, y, z);
        System.out.println(point3D.toString());
        System.out.println(point2D.toString());

    }
}

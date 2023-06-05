package ss2_vong_lap_java.bai_tap;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        int height;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao của hình vào đây");
        height = sc.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                    System.out.println("*");
            }
            System.out.println();
        }
    }
}

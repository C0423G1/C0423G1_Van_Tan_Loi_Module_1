package ss2_vong_lap_java.bai_tap;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1.Print the rectangle" +
                    "\n2.Print the square Triangle " +
                    "\n3.Print isosceles Triangle" +
                    "\n4.Exit");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    int height;
                    System.out.println("Nhập chiều cao của hình vào đây");
                    height = sc.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < height; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int heightOne;
                    System.out.println("Nhập chiều cao của hình vào đây");
                    heightOne = sc.nextInt();
                    for (int i = 0; i < heightOne; i++) {
                        for (int j = 0; j < heightOne; j++) {
                            if (i - j >= 0) {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < heightOne; i++) {
                        for (int j = 0; j < heightOne; j++) {
                            if (i - j <= 0) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < heightOne; i++) {
                        for (int j = 0; j < heightOne; j++) {
                            if (i + j >= heightOne - 1) {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < heightOne; i++) {
                        for (int j = 0; j < heightOne; j++) {
                            if (i + j <= heightOne - 1) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int heightTwo;
                    System.out.println("Nhập chiều cao của hình vào đây");
                    heightTwo = sc.nextInt();
                    for (int i = 0; i <= heightTwo; i++) {
                        for (int j = 0; j <= heightTwo * 2; j++) {
                            if (i + j > heightTwo && j - i < heightTwo) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                case 4:
                    flag = false;
            }
        } while (flag == true);


    }
}

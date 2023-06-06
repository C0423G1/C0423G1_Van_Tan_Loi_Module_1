package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử bạn muốn nhập vào đây bao nhiêu mảng");
        int one = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[one][];
        for (int i = 0; i < one; i++) {
            System.out.println("Mời bạn nhập vào độ dài phần tử thứ " + (i + 1));
            array[i] = new int[Integer.parseInt(scanner.nextLine())];
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Mời bạn nhập vào đây phần tử thứ " + (j + 1) + " của mảng " + (i + 1));
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println(Arrays.deepToString(array));
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        System.out.println(min);
    }
}

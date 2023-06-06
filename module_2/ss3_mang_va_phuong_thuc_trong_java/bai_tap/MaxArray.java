package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử bạn muốn nhập vào đây bao nhiêu mảng");
        int a = Integer.parseInt(sc.nextLine());
        int[][] array = new int[a][];
        for (int i = 0; i < a; i++) {
            System.out.println("Mời bạn nhập vào độ dài phần tử thứ " + (i + 1));
            array[i] = new int[Integer.parseInt(sc.nextLine())];
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Mời bạn nhập vào đây phần tử thứ " + (j + 1) + " của mảng " + (i + 1));
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println(Arrays.deepToString(array));
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println(max);
    }
}

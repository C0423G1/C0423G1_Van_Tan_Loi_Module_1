package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bạn nhập số lượng phần tử bạn muốn nhập vào đay");
            a = sc.nextInt();
        } while (a <= 0);
        int[] array = new int[a];
        for (int i = 1; i <= a; i++) {
            System.out.println("Nhập phần tử thứ " + i + " vào đây");
            array[i - 1] = sc.nextInt();
        }
        int[] arrayOne = new int[a - 1];
        System.out.println("Nhập phần tử bạn muốn xoá vào đây");
        int d = sc.nextInt();
        for (b = c = 0; c < array.length; c++) {
            if (array[c] != d) {
                arrayOne[b] = array[c];
                b++;
            } else {
                System.out.println("Phần tử bạn muốn xoá nằm ở vị trí " + (c + 1));
            }
        }
        System.out.println(Arrays.toString(arrayOne));
    }
}

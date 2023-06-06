package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ReduceArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng phần tử bạn nhập vào mảng 1");
        int a = sc.nextInt();
        System.out.println("Mời bạn nhập số lượng phần tử vào mảng 2");
        int b = sc.nextInt();
        int[] array = new int[a + b];
        int[] arrayOne = new int[a];
        int[] arrayTwo = new int[b];
        for (int i = 0; i < a; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ " + (i + 1) + " của mảng 1");
            arrayOne[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ " + (i + 1) + " của mảng 2");
            arrayTwo[i] = sc.nextInt();
        }
        for (int i = 0; i < arrayOne.length; i++) {
            array[i] = arrayOne[i];
        }
        for (int i = arrayOne.length; i < array.length; i++) {
            array[i] = arrayTwo[i - arrayOne.length];
        }
        System.out.println(Arrays.toString(array));
    }

}

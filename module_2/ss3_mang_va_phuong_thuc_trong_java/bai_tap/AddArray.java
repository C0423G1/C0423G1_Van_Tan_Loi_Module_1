package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số phần tử bạn muốn nhập vào :");
        a = sc.nextInt();
        int[] array = new int[a];
        for (int i = 1; i <= a; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ :" + i);
            b = sc.nextInt();
            array[i - 1] = b;
        }
        int[] arrayOne = new int[a + 1];
        System.out.println("Mời bạn chọn phần tử bạn muốn thêm vào mảng ");
        c = sc.nextInt();
        System.out.println("Mời bạn chọn ví trí bạn muốn chèn");
        int d = sc.nextInt();
        for (int i = 0; i < arrayOne.length; i++) {
            if (i < d - 1) {
                arrayOne[i] = array[i];
            } else if (i == d - 1) {
                arrayOne[i] = c;
            } else {
                arrayOne[i] = array[i - 1];
            }
        }
        System.out.println(Arrays.toString(arrayOne));
    }
}

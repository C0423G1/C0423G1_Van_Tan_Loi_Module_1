package ss14_thuat_toan_sap_xep;

import java.util.Arrays;
import java.util.Scanner;

public class SortAlorithmTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng phần tử bạn muốn nhập vào mảng");
        int size = Integer.parseInt(sc.nextLine());
        int[] number = new int[size];
        for (int i = 0; i < number.length; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ " + (i + 1));
            int n = Integer.parseInt(sc.nextLine());
            number[i] = n;
        }
        SortAlorith(number);
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }

    public static void SortAlorith(int[] array) {
        int pos;
        int x;
        for (int i = 0; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            System.out.println("lần thứ " + (i + 1) + " :" + Arrays.toString(array));
            array[pos] = x;
        }
    }

}

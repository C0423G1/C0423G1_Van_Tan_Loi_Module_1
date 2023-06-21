package ss14_thuat_toan_sap_xep;

import java.util.Scanner;

public class SortAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng phần tử bạn muốn nhập vào mảng");
        int size = Integer.parseInt(scanner.nextLine());
        int[] number = new int[size];
        for (int i = 0; i < number.length; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ " + (i + 1));
            int n = Integer.parseInt(scanner.nextLine());
            number[i] = n;
        }
        SortAlorith(number);
    }

    public static void SortAlorith(int[] array) {
        int pos;
        int x;
        for (int i = 0; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                System.out.println();
                pos--;
            }
            array[pos] = x;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }

}

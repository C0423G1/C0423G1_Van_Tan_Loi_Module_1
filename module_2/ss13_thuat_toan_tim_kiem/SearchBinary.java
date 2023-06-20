package ss13_thuat_toan_tim_kiem;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;


public class SearchBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn nhập bao nhiêu phần tử");
        int count = Integer.parseInt(sc.nextLine());
        int[] number = new int[count];
        for (int i = 0; i < number.length; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ " + (i + 1));
            int a = Integer.parseInt(sc.nextLine());
            number[i] = a;
        }
        System.out.println("số phần tử bạn muốn tìm vị trí");
        int search = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < number.length; j++) {
            for (int i = 0; i < number.length - 1; i++) {
                if (number[i] > number[i + 1]) {
                    int check = number[i];
                    number[i] = number[i + 1];
                    number[i + 1] = check;
                }
            }
        }
        System.out.println(Arrays.toString(number));
        System.out.println(binarySearch(number, 0, number.length - 1, search));
    }

    static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value < array[middle]) {
                return binarySearch(array, left, middle - 1, value);
            } else if (value > array[middle]) {
                return binarySearch(array, middle + 1, right, value);
            }
        }
        return -1;
    }
}

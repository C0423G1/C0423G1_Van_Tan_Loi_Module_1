package ss14_thuat_toan_sap_xep;

import java.util.Arrays;
import java.util.Scanner;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] number = {-1, 150, 190, 170, -1, -1, 160, 180};
        System.out.println(Arrays.toString(SortAlorith(number)));
    }

    public static int[] SortAlorith(int[] a) {
        int p;
        int x;
        for (int i = 0; i < a.length; i++) {
            x = a[i];
            p = i;
            while (p > 0 && x < a[p - 1]) {
                if (x != -1 || a[p - 1] != -1) {
                    a[p] = a[p - 1];
                    p--;
                }
            }
            a[p] = x;
        }
       return a;
    }

}

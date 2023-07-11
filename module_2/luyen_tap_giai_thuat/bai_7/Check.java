package luyen_tap_giai_thuat.bai_7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Check {
    public static int[] check(int[][] number) {
        int[] checknumber = new int[(number.length) * (number.length)];
        int f = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length; j++) {
                checknumber[f] = number[i][j];
                f++;
            }
        }
        ArrayList<Integer> numberCheck = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < checknumber.length; i++) {
            flag = true;
            for (int j = 2; j < checknumber[i]; j++) {
                if (checknumber[i] % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && checknumber[i] != 0 && checknumber[i] != 1) {
                numberCheck.add(checknumber[i]);
            }
        }
        for (int i = 0; i < numberCheck.size() - 1; i++) {
            for (int j = i + 1; j < numberCheck.size(); j++) {
                if (numberCheck.get(i) < numberCheck.get(j)) {
                    int a = numberCheck.get(i);
                    numberCheck.set(i, numberCheck.get(j));
                    numberCheck.set(j, a);
                }
            }
        }
        int[] numberSum = new int[numberCheck.size()];
        for (int i = 0; i < numberSum.length; i++) {
            numberSum[i] = numberCheck.get(i);
        }
        return numberSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời Nhậ Kích cỡ của mảng (n*n)");
        int length = Integer.parseInt(scanner.nextLine());
        int[][] number = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

            }
        }
        System.out.println(Arrays.toString(check(number)));
    }
}

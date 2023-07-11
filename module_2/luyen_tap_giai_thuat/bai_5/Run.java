package luyen_tap_giai_thuat.bai_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng");
        int length = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập vào đây số mảng thứ " + (i + 1));
            int check = Integer.parseInt(scanner.nextLine());
            arrayList.add(check);
        }
        System.out.println(Check.check(arrayList));
    }
}

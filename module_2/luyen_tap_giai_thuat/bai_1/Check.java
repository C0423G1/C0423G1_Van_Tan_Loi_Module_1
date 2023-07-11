package luyen_tap_giai_thuat.bai_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Bạn Muốn Nhập Bao Nhiêu Phần tử");
        int length = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            System.out.println("Mời Bạn Nhập Phần Tử Thứ : " + (i + 1));
            int check = Integer.parseInt(scanner.nextLine());
            list.add(check);
        }
        System.out.println(Run.check(list));
    }
}

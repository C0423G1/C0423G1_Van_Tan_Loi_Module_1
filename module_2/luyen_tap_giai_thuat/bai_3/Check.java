package luyen_tap_giai_thuat.bai_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    public static void Check(ArrayList<Integer> arrayList) {

        boolean flag = true;
        for (int j = 0; j < arrayList.size(); j++) {
            int sum = 0;
            int sumOne = 0;
            for (int i = 0; i < j; i++) {
                sum = sum + arrayList.get(i);
            }
            for (int i = j + 1; i < arrayList.size(); i++) {
                sumOne = sumOne + arrayList.get(i);
            }
            if (sum == sumOne) {
                flag = false;
                System.out.println(true);
                break;
            }
        }
        if (flag == true) {
            System.out.println(false);
        }
    }

    public static ArrayList<Integer> write(ArrayList<Integer> arrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng vào mảng");
        int length = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            System.out.println("Mời Bạn Nhập Vào Đây Phần Tử Thứ :" + (i + 1));
            int check = Integer.parseInt(scanner.nextLine());
            arrayList.add(check);
        }
        return arrayList;
    }
}

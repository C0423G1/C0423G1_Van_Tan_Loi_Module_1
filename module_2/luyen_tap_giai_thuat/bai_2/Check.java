package luyen_tap_giai_thuat.bai_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    public static void String(ArrayList<String> arrayList, ArrayList<String> arrayListOne) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < arrayList.size(); i++) {
            flag = true;
            for (int j = 0; j < arrayListOne.size(); j++) {
                if (arrayList.get(i).equals(arrayListOne.get(j))) {
                    flag = false;
                    arrayList.remove(i);
                    arrayListOne.remove(j);
                    count++;
                    j--;
                    break;
                }
            }
            if (!flag) {
                i--;
            }
        }
        System.out.println(count);
    }

    public static ArrayList<String> write(ArrayList<String> arrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng vào mảng");
        int length = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            System.out.println("Mời Bạn Nhập Vào Đây Phần Tử Thứ :" + (i + 1));
            String check = scanner.nextLine();
            arrayList.add(check);
        }
        return arrayList;
    }


}

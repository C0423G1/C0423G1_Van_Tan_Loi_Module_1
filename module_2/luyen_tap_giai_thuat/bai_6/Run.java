package luyen_tap_giai_thuat.bai_6;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ");
        String string = scanner.nextLine();
        System.out.println(Check.findChar(string));
    }
}

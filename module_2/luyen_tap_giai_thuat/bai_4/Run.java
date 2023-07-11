package luyen_tap_giai_thuat.bai_4;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Chuỗi");
        String string = scanner.nextLine();
        String check = Check.check(string);
        System.out.println(check);

    }
}

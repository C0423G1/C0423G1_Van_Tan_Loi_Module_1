package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class Untitled {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tiền usd cần đổi");
        usd = Double.parseDouble(sc.nextLine());
        double quydoi = usd * 23000;
        System.out.println("Giá trị VND : " + quydoi);
    }
}

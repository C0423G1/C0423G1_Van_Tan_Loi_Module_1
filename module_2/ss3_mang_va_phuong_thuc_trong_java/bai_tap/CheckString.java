package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class CheckString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "";
        System.out.print("Nhập chuỗi vào đây");
        a = sc.nextLine();
        System.out.print("Nhập từ cần kiểm tra vào đây ");
        char b = sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                count++;
            }
        }
        System.out.println("Ký tự " + b + " được lặp lại " + count);
    }

}

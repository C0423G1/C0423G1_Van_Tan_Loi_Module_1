package ss11_dsa_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra vào đây");
        String string = sc.nextLine();
        System.out.println(checkBracket(string));
    }

    public static String checkBracket(String str) {
        String[] arrStr = str.split("");
        Stack<String> strSym = new Stack<>();
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals("(")) {
                strSym.push(arrStr[i]);
            } else if (arrStr[i].equals(")")) {
                if (strSym.isEmpty()) {
                    return "???";
                }

            }
        }
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals(")")) {
                if (!strSym.isEmpty()) {
                    strSym.pop();
                } else {
                    return "???";
                }
            }
        }
        if (strSym.isEmpty()) {
            return "well";
        } else {
            return "???";
        }
    }

}

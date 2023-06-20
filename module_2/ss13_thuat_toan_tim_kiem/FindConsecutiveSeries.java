package ss13_thuat_toan_tim_kiem;

import java.util.LinkedList;
import java.util.Scanner;

public class FindConsecutiveSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi bạn mun kiểm tra vào đây : ");
        String string = input.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> count = new LinkedList<>();


        for (int i = 0; i < string.length(); i++) {
            if (count.size() > 1 && string.charAt(i) <= count.getLast() &&
                    count.contains(string.charAt(i))) {
                count.clear();
            }

            count.add(string.charAt(i));

            if (count.size() > max.size()) {
                max.clear();
                max.addAll(count);
            }
        }


        for (Character characters : max) {
            System.out.print(characters);
        }
        System.out.println();
    }


}

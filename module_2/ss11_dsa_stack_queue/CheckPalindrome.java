package ss11_dsa_stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi của bạn vào đây");
        String string = scanner.nextLine();
        String[] strings = string.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        int count = strings.length;
        for (int i = 0; i < count; i++) {
            stack.push(strings[i]);
            queue.add(strings[i]);
        }
        boolean flag = true;
        System.out.println(stack);
        System.out.println(queue);
        for (int i = 0; i < count; i++) {
            if (stack.pop().equals(queue.remove())) {
                flag = false;
            } else {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("chuỗi này là chuỗi Palindrome");
        } else if (flag == true) {
            System.out.println("chuỗi này không phải là chuỗi Palindrome");
        }
    }
}

package ss11_dsa_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời Bạn nhập số vào đây");
        int number = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        System.out.println(stack);
        int count = stack.size();
        for (int i = 0; i < count; i++) {
            stack1.push(stack.pop());
        }
        System.out.println(stack1);

    }
}

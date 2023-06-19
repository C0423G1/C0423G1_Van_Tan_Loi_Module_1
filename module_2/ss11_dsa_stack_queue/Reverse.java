package ss11_dsa_stack_queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int c = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng phần tử bạn muốn nhập vào đây :");
        c = sc.nextInt();
        int[] array = new int[c];
        for (int i = 1; i <= c; i++) {
            System.out.println("Mời bạn nhập vào đây phần tử thứ :" + i);
            b = sc.nextInt();
            array[i - 1] = b;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        System.out.println(stack);
        for (int i = 0; i < array.length; i++) {
            stack1.push(stack.pop());
        }
        System.out.println(stack1);
        System.out.println(stack);
    }
}

package luyen_tap_giai_thuat.bai_8;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mảng cha: ");
        String parentInput = scanner.nextLine();
        String[] parentArray = parentInput.split(",");

        System.out.print("Nhập mảng con: ");
        String childInput = scanner.nextLine();
        String[] childArray = childInput.split(",");

        int count = findSubarrayCount(parentArray, childArray);
        System.out.println("Số lần xuất hiện của mảng con trong mảng cha: " + count);
    }

    public static int findSubarrayCount(String[] parentArray, String[] childArray) {
        int count = 0;
        for (int i = 0; i <= parentArray.length - childArray.length; i++) {
            boolean isSubarray = true;
            for (int j = 0; j < childArray.length; j++) {
                if (!parentArray[i + j].equals(childArray[j])) {
                    isSubarray = false;
                    break;
                }
            }
            if (isSubarray) {
                count++;
            }
        }
        return count;
    }
}

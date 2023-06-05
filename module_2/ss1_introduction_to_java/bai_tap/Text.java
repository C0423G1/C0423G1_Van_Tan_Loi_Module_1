package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        do {
            int number;
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số bạn cần đọc vào đây");
            number = sc.nextInt();
            int[] so = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            String[] chu = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen"};
            if (number <= 15) {
                for (int i = 0; i < so.length; i++) {
                    if (number == so[i]) {
                        System.out.println(chu[i]);
                    }
                }
            } else if (number < 20 && number > 16) {
                for (int i = 0; i < so.length; i++) {
                    if ((number - 10) == so[i]) {
                        System.out.println(chu[i] + "teen");
                    }
                }
            } else if (number >= 20 && number < 100) {
                if (number % 10 == 0) {
                    for (int i = 0; i < so.length; i++) {
                        if ((number / 10) == so[i]) {
                            System.out.println(chu[i] + "ty");
                        }
                    }
                } else {
                    for (int i = 0; i < so.length; i++) {
                        if ((number / 10) == so[i]) {
                            for (int j = 0; j < so.length; j++) {
                                if ((number % 10) == so[j]) {
                                    System.out.println(chu[i] + "ty-" + chu[j]);
                                }
                            }
                        }
                    }
                }
            } else if (number >= 100) {
                if (number % 100 == 0) {
                    for (int i = 0; i < so.length; i++) {
                        if ((number / 100) == so[i]) {
                            System.out.println(chu[i] + " hundred");
                        }
                    }
                } else {
                    for (int k = 0; k < so.length; k++) {
                        if (number / 100 == so[k]) {
                            if (number % 10 == 0) {
                                for (int i = 0; i < so.length; i++) {
                                    if ((number / 10) == so[i]) {
                                        System.out.println(chu[k] + " hundred " + chu[i] + "ty");
                                    }
                                }
                            } else if (number % 100 < 16 && number % 100 > 0) {
                                for (int i = 0; i < so.length; i++) {
                                    if ((number % 100) == so[i]) {
                                        System.out.println(chu[k] + " hundred " + chu[i]);
                                    }
                                }
                            } else {
                                for (int i = 0; i < so.length; i++) {
                                    if (((number % 100) / 10) == so[i]) {
                                        for (int j = 0; j < so.length; j++) {
                                            if (((number % 100) % 10) == so[j]) {
                                                System.out.println((chu[k] + " hundred " + chu[i] + "ty-" + chu[j]));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (true);
    }
}

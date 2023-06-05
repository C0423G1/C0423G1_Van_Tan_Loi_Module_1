package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class NumberToLetters {
    public static void main(String[] args) {
        int number;
        System.out.println("Mời bạn nhập số vào đây");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        String result = convertNumberToLetters(number);
        System.out.println(result);
    }

    public static String convertNumberToLetters(int number) {
        String result = "";

        if (number < 0 || number > 999) {
            return "Number out of range";
        }

        int hundreds = number / 100;
        switch (hundreds) {
            case 1:
                result += "One Hundred ";
                break;
            case 2:
                result += "Two Hundred ";
                break;
            case 3:
                result += "Three Hundred";
                break;
            case 4:
                result += "Four Hundred";
                break;
            case 5:
                result += "Five Hundred";
                break;
            case 6:
                result += "Six Hundred";
                break;
            case 7:
                result += "Seven Hundred";
                break;
            case 8:
                result += "Eight Hundred";
                break;
            case 9:
                result += "Nine Hundred ";
                break;
        }

        int tens = (number / 10) % 10;
        int ones = number % 10;

        if (tens == 1) {
            switch (ones) {
                case 0:
                    result += "Ten";
                    break;
                case 1:
                    result += "Eleven";
                    break;
                case 2:
                    result += "twelve ";
                    break;
                case 3:
                    result += "thirteen";
                    break;
                case 4:
                    result += "fourteen";
                    break;
                case 5:
                    result += "fifteen";
                    break;
                case 6:
                    result += "sixteen";
                    break;
                case 7:
                    result += "seventeen";
                    break;
                case 8:
                    result += "Eightteen";
                    break;
                case 9:
                    result += "Nineteen";
                    break;
            }
        } else {
            switch (tens) {
                case 2:
                    result += "Twenty ";
                    break;
                case 3:
                    result += "Thirty ";
                    break;
                case 4:
                    result += "fourty";
                    break;
                case 5:
                    result += "fifty";
                    break;
                case 6:
                    result += "sixty";
                    break;
                case 7:
                    result += "seventy";
                    break;
                case 8:
                    result += "Eightty";
                    break;
                case 9:
                    result += "Ninety ";
                    break;
            }

            switch (ones) {
                case 1:
                    result += "One";
                    break;
                case 2:
                    result += "Two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "Eight";
                    break;
                case 9:
                    result += "Nine";
                    break;
            }
        }

        return result;
    }
}

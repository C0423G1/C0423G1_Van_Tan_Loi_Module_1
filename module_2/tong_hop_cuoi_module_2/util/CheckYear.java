package tong_hop_cuoi_module_2.util;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckYear {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static boolean is18YearsOld(String dateOfBirth) {
        String regex = "^([0-2][0-9])-([0-1][0-9])-([1-2][0-9]{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirth);

        if (matcher.matches()) {
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            boolean isLeap = isLeapYear(year);

            boolean isFebruaryValid = (month == 2 && day <= (isLeap ? 29 : 28));

            Calendar currentDate = Calendar.getInstance();
            int currentYear = currentDate.get(Calendar.YEAR);
            int currentMonth = currentDate.get(Calendar.MONTH) + 1;
            int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

            int age = currentYear - year;

            if (age > 18 || (age == 18 && (
                    currentMonth > month ||
                            (currentMonth == month && currentDay >= day) ||
                            (currentMonth == month && currentDay == day && isFebruaryValid)
            ))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ");
        String a = scanner.nextLine();
        System.out.println(CheckYear.is18YearsOld(a));
    }
}

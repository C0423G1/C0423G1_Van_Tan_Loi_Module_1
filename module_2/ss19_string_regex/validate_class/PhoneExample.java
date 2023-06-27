package ss19_string_regex.validate_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_REGEX = "^[0-9]{2}-0[0-9]{9}$";

    public PhoneExample() {
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String string) {
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static PhoneExample phone = new PhoneExample();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("check số điện thoại");
        String checkPhone = scanner.nextLine();
        boolean isvalid = phone.validate(checkPhone);
        System.out.println(isvalid);
    }

}

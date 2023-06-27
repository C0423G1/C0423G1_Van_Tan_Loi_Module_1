package ss19_string_regex.validate_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CLASS_REGEX = "^[CAP]+[0-9]{4}+[GHIK]$";

    public ClassExample() {
        pattern = Pattern.compile(CLASS_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static ClassExample nameClassOne = new ClassExample();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Class Vào Đây Kiểm Tra");
        String nameClass = scanner.nextLine();
        boolean isvalid = nameClassOne.validate(nameClass);
        System.out.println(isvalid);

    }
}

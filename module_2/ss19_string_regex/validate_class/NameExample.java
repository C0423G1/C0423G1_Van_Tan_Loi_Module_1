package ss19_string_regex.validate_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameExample {
    private static Pattern pattern;
    private Matcher matcher;
    public static final String NAME_REGEX = "^[A-Z][a-z]+( [A-Z][a-z]*)+$";

    public NameExample() {
        pattern = Pattern.compile(NAME_REGEX);
    }

    public boolean checkName(String string) {
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static NameExample nameExample = new NameExample();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean check;
        do {
            System.out.println("Mời Bạn Nhập Tên Vào Đây");
            String name = scanner.nextLine();
            check = nameExample.checkName(name);
            flag = true;
            if (check == false) {
                flag = false;
                System.out.println("Nhập lại");
            }
        } while (!flag);
        System.out.println(check);
    }
}

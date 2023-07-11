package luyen_tap_giai_thuat.bai_4;

public class Check {
    public static String check(String string) {
        String check = "";
        for (int i = 0; i < string.length(); i++) {
            if (i > 0 && Character.isUpperCase(string.charAt(i)) && Character.isLetter(string.charAt(i + 1))) {
                check += " ";
            }
            check += Character.toLowerCase(string.charAt(i));
        }
        return check;
    }
}

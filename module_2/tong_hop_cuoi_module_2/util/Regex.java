package tong_hop_cuoi_module_2.util;

public class Regex {
    private final static String CHECK_ID = "^NV\\-[0-9]{4}$";
    private final static String CHECK_NAME = "^[A-Z][a-z]+( [A-Z][a-z]*)+$";
    private final static String CHECK_NUMBER_NAME = "^[0-9]{9}|[0-9]{12}$";
    private final static String CHECK_DATE = "^(\\d{2})\\-(\\d{2})\\-(\\d{4})$";
    private final static String CHECK_NUMBER_PHONE = "^0\\d{9}$";
    private final static String CHECK_EMAIL = "^[a-z]\\w{5,}@[a-z]{2,5}\\.[a-z]{2,5}$";
    private final static String CHECK_ID_ONE = "^KH\\-[0-9]{4}$";


    public static boolean checkID(String id) {
        return id.matches(CHECK_ID);
    }
    public static boolean checkIDOne(String id) {
        return id.matches(CHECK_ID_ONE);
    }

    public static boolean checkName(String name) {
        return name.matches(CHECK_NAME);
    }

    public static boolean checkNumberName(String name) {
        return name.matches(CHECK_NUMBER_NAME);
    }

    public static boolean checkDate(String date) {
        return date.matches(CHECK_DATE);
    }

    public static boolean checkNumberPhone(String date) {
        return date.matches(CHECK_NUMBER_PHONE);
    }
    public static boolean checkEmail(String email) {
        return email.matches(CHECK_EMAIL);
    }
}

package tong_hop_cuoi_module_2.util;

public class Regex {
    private final static String CHECK_ID = "^NV\\-[0-9]{4}$";
    private final static String CHECK_NAME = "^[A-Z][a-z]+( [A-Z][a-z]*)+$";
    private final static String CHECK_NUMBER_NAME = "^[0-9]{9}|[0-9]{12}$";
    private final static String CHECK_NUMBER_PHONE = "^0(9||8||7)\\d{8}$";
    private final static String CHECK_EMAIL = "^[a-z]\\w{5,}@[a-z]{2,5}\\.[a-z]{2,5}$";
    private final static String CHECK_ID_ONE = "^KH\\-[0-9]{4}$";
    private final static String CHECK_ADDRESS = "^(?!.*(?:00|,000|0000|00000)).*\\-[A-Z][a-z]+( [A-Z][a-z]*)+\\-[A-Z][a-z]+( [A-Z][a-z]*)+$";
    private final static String CHECK_ID_VILLA = "^SVVL\\-[0-9]{4}$";
    private final static String CHECK_ID_HOUSE = "^SVHO\\-[0-9]{4}$";
    private final static String CHECK_ID_ROOM = "^SVRO\\-[0-9]{4}$";
    private final static String CHECK_NAME_FACILITY = "^[A-Z][a-z]{1,}[a-z]{1,}$";

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

    public static boolean checkNumberPhone(String date) {
        return date.matches(CHECK_NUMBER_PHONE);
    }

    public static boolean checkEmail(String email) {
        return email.matches(CHECK_EMAIL);
    }

    public static boolean checkAddress(String address) {
        return address.matches(CHECK_ADDRESS);
    }

    public static boolean checkHouse(String house) {
        return house.matches(CHECK_ID_HOUSE);
    }

    public static boolean checkRooom(String room) {
        return room.matches(CHECK_ID_ROOM);
    }

    public static boolean checkVilla(String villa) {return villa.matches(CHECK_ID_VILLA);}
    public static boolean checkNameFacility(String facility) {return facility.matches(CHECK_NAME_FACILITY);}
}

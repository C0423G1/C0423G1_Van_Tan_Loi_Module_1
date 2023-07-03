package tong_hop_cuoi_module_2.util;

public class CheckTypeOfGuest {
    public static boolean checkTypeOfGuest(String typeOfGuest) {
        if (typeOfGuest.equals("(Diamond") || typeOfGuest.equals("Platinum") || typeOfGuest.equals("Gold") || typeOfGuest.equals("Silver") || typeOfGuest.equals("Member")) {
            return true;
        }
        return false;
    }
}

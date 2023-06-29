package tong_hop_cuoi_module_2.util;

public class CheckPosition {
    public static boolean checkPosition(String position) {
        if (position.equals("lễ tân") || position.equals("phục vụ") || position.equals("chuyên viên") || position.equals("giám sát") || position.equals("quản lí") || position.equals("giám đốc")) {
            return true;
        }
        return false;
    }
}

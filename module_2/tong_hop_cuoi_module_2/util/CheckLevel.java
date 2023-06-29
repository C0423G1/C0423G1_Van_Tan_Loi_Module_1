package tong_hop_cuoi_module_2.util;

public class CheckLevel {
    public static boolean checkLevel(String level) {
        if (level.equals("Trung cấp") || level.equals("Cao đẳng") || level.equals("Đại học") || level.equals("Sau đại học")) {
            return true;
        }
        return false;
    }
}

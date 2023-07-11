package luyen_tap_giai_thuat.bai_1;

import java.util.ArrayList;

public class Run {
    public static boolean check(ArrayList<Integer> list) {
        int count = 0;
        boolean flag = true;
        int length = list.size();
        for (int i = 0; i < list.size(); i++) {
            int countCheck = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    countCheck++;
                    j--;
                }
            }
            if (i == 0) {
                count = countCheck;
            } else if (countCheck == count) {
                count = countCheck;
            } else if (countCheck != count) {
                return false;
            }
        }
        return true;
    }
}

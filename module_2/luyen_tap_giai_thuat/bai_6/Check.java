package luyen_tap_giai_thuat.bai_6;

import java.util.ArrayList;
import java.util.List;

public class Check {

    public static char[] findChar(String string) {
        int[] charCount = new int[256];
        for (char c : string.toCharArray()) {
            charCount[c]++;
        }
        List<Character> result = new ArrayList<>();
        for (char c = 0; c < 256; c++) {
            if (charCount[c] > 1) {
                result.add(c);
            }
        }
        char[] resultArray = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }


}

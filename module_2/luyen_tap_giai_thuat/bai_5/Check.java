package luyen_tap_giai_thuat.bai_5;

import java.util.ArrayList;

public class Check {
    public static ArrayList<Integer> check(ArrayList<Integer> arrayList) {
        for (int j = 0; j < arrayList.size(); j++) {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) >= arrayList.get(i + 1) || arrayList.get(i) == -1 || arrayList.get(i + 1) == -1) {
                }else if(arrayList.get(i) < arrayList.get(i + 1)){
                    int check = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, check);
                }
            }
        }
        return arrayList;
    }
}

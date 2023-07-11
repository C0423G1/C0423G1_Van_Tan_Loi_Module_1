package luyen_tap_giai_thuat.bai_2;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Check.write(arrayList);
        ArrayList<String> arrayListOne = new ArrayList<>();
        Check.write(arrayListOne);
        Check.String(arrayList, arrayListOne);
    }
}

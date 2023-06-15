package ss8_clean_code;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("new element");
        arr.add("b");
        arr.add("c");
        arr.add("e");
        arr.add("f");
        List<String> newList = arr.subList(1,4);
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
    }
}

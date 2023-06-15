package ss10_dsa_danh_sach;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 3: " + listInteger.get(3));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));
        System.out.println("size : " + listInteger.getSize());
        System.out.println("IndexOf : " + listInteger.indexOf(3));
    }
}

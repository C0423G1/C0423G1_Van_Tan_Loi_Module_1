package ss4_class_object.bai_tap;

import java.util.Scanner;

public class RunStopWatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.StarTime" + "2.StopTime" + "3.EndTime");
        int a = sc.nextInt();
        StopWatch watch = new StopWatch();
        switch (a) {
            case 1:
                System.out.println(watch.getStartTime());
                break;
            case 2:
                System.out.println(watch.getEndTime());
                break;
            case 3:
                System.out.println(watch.getElapsedTime());

        }
        System.out.println("1.StarTime" + "2.StopTime" + "3.EndTime");
        a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println(watch.getStartTime());
                break;
            case 2:
                System.out.println(watch.getEndTime());
                break;
            case 3:
                System.out.println(watch.getElapsedTime());

        }
        System.out.println("1.StarTime" + "2.StopTime" + "3.EndTime");
        a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println(watch.getStartTime());
                break;
            case 2:
                System.out.println(watch.getEndTime());
                break;
            case 3:
                System.out.println(watch.getElapsedTime());

        }

    }
}

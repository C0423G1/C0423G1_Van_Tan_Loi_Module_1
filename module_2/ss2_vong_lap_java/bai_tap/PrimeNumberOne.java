package ss2_vong_lap_java.bai_tap;

public class PrimeNumberOne {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            long count = 0;
            for (int j = 1; j < 500; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(i);
            }
        }
    }
}

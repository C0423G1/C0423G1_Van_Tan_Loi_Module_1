package ss15_exception;

import java.util.Scanner;

public class Check {

    public static void checkTriangleEdges(double a, double b, double c) throws TriangleEdgesException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdgesException("Tam giac khong hop le");
        } else {
            System.out.println("Tam giac hop le");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            try {
                flag = true;
                System.out.println("Nhập chiều dài cạnh thứ nhất của tam giác");
                double a = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập chiều dài cạnh thứ hai của tam giác");
                double b = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập chiều dài cạnh thứ ba của tam giác");
                double c = Double.parseDouble(scanner.nextLine());
                checkTriangleEdges(a, b, c);
            } catch (TriangleEdgesException e) {
                flag = false;
                System.out.println(e.getMessage());
            } catch (Exception e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        } while (flag == false);
    }
}


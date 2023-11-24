import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {
//   ---------------------------- Khái niệm Lambda Java 8 ---------------------------
//    Lambda Expression là một hàm không có tên  với các tham số và nội dung thực thi .
//    Nội dung thực thi của Lambda expression có thể là 1 khối lệnh hoặc 1 biểu thức.
//    Dấu “->” tách biệt các tham số và nội dung thực thi.

    //    ---------------  DEMO --------------------------------------
    public static void main(String[] args) {
        // Tạo một mảng các số nguyên
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Sử dụng Stream API để tính tổng các phần tử trong mảng
        // Phương thức reduce có tham số đầu tiên là giá trị khởi tạo (ở đây là 0),
        // tham số thứ hai là biểu thức lambda thực hiện phép cộng
        int sum = Arrays.stream(arr).reduce(0, (b, c) -> b + c);
        // In ra tổng của các phần tử trong mảng
        System.out.println(sum);
    }
}

/* Bài 3: Tìm tổng nhỏ nhất của hai số được tạo từ mảng A
Để tổng của hai số là nhỏ nhất, thuật toán tham lam:
1.	Sắp xếp mảng A theo thứ tự tăng dần.
2.	Phân bổ các chữ số nhỏ nhất vào các hàng cao nhất (hàng chục, hàng trăm...) của hai số một cách luân phiên.
3.	Ghép số: Chữ số ở vị trí index chẵn sẽ thuộc về số thứ nhất, vị trí index lẻ thuộc về số thứ hai.
*/
import java.util.Arrays;
import java.util.Scanner;
public class Ex3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            // Đọc các phần tử của mảng
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            //sx tăng dần
            Arrays.sort(a);     
            // Tạo hai số từ các chữ số đã sắp xếp
            long num1 = 0, num2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    num1 = num1 * 10 + a[i];
                } else {
                    num2 = num2 * 10 + a[i];
                }
            }
            System.out.println(num1 + num2);
        }
        sc.close();
    }
}
/*Độ phức tạp thời gian: O(N \log N)*/
/* Mảng con liên tục có tổng lớn nhất (Maximum Subarray Sum)
(a) Mô tả thuật toán(Quy hoạch động):
1.	Khởi tạo max_so_far và current_max bằng phần tử đầu tiên của mảng.
2.	Duyệt từ phần tử thứ 2 đến hết mảng.
3.	Tại mỗi bước i, current_max sẽ là giá trị lớn hơn giữa A[i] và (current\_max + A[i]). 
(Tiếp tục cộng dồn vào mảng con hiện tại hay bắt đầu một mảng con mới từ A[i]).
4.	Cập nhật max_so_far = max(max_so_far, current_max).
(b) 
Đánh giá độ phức tạp 
•	Độ phức tạp thời gian: O(N) vì chỉ cần duyệt qua mảng một lần duy nhất.
*/

import java.util.Scanner;
public class Ex4_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n=sc.nextInt();
            if (n <= 0) {
                System.out.println("Kich thuoc mang khong hop le.");
                sc.close();
                return;
            }
            int[] a=new int[n];
            for (int i=0; i<n; i++){
                a[i]=sc.nextInt(); 
            }

            long maxSoFar=a[0];
            long currentMax=a[0];
            int startIndex=0, maxStart=0, maxEnd=0;

            for (int i=1; i<n; i++) {
                if (a[i] > currentMax + a[i]) {
                    currentMax = a[i];
                    startIndex = i;
                } else {
                    currentMax = currentMax + a[i];
                }
                
                if (currentMax > maxSoFar) {
                    maxSoFar = currentMax;
                    maxStart = startIndex;
                    maxEnd = i;
                }
            }

            System.out.print("Mang con: ");
            for (int i = maxStart; i <= maxEnd; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            System.out.println("Tong lon nhat: " + maxSoFar); 
        }
        sc.close();
    }
}
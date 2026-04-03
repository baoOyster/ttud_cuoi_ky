package chau;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/** 
 * Độ phức tạp thời gian: O(N.p(N)), trong đó p(N) là số cách phân hoạch (với N=10$, p(10)=42 nên thuật toán chạy cực nhanh).
 * Mỗi cách phân tích là một nhánh của cây đệ quy; thuật toán duyệt qua từng nhánh và mất tối đa O(N) để in từng bộ số đó ra màn hình.
 */
public class Ex1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hay nhap so tu nhien N (1 <= N <= 10): ");
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n >= 1 && n <= 10) {
                System.out.print("Ket qua: ");
                List<Integer> currentPartition = new ArrayList<>();
                backtrack(n, n, currentPartition);
                System.out.println(); 
            } else {
                System.out.println("Loi: N phai nam trong khoang tu 1 den 10.");
            }
        } else {
            System.out.println("Loi: Vui long nhap mot so nguyen.");
        }
        
        sc.close();
    }
    

    /**
     * Hàm đệ quy quay lui để tìm các cách phân hoạch
     * target: Số còn lại cần phải phân tích thành tổng
     * maxVal: Số lớn nhất có thể chọn ở bước này (để tránh lặp hoán vị)
     * current: Danh sách lưu cách phân chia hiện tại
     */
    private static void backtrack(int target, int maxVal, List<Integer> current) {
        // Trường hợp cơ sở: Nếu target = 0, ta đã tìm được một cách phân tích hoàn chỉnh
        if (target == 0) {
            printPartition(current);
            return;
        }
        // Thử chọn các số từ maxVal giảm dần xuống 1
        for (int i = Math.min(target, maxVal); i >= 1; i--) {
            current.add(i); // Chọn số i
            backtrack(target - i, i, current); // Đệ quy cho phần còn lại
            current.remove(current.size() - 1); // Bỏ số i ra để thử số khác (Backtrack)
        }
    }

    //Hàm in theo định dạng (x y z)
    private static void printPartition(List<Integer> partition) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < partition.size(); i++) {
            sb.append(partition.get(i));
            if (i < partition.size() - 1) {
                sb.append(" "); 
            }
        }
        sb.append(") "); 
        System.out.print(sb.toString());
    }
}

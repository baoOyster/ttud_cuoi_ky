package chau;
import java.util.*;
//Độ phức tạp tính toán là O(N*M) do chúng ta phải điền vào bảng L có kích thước (n+1) x (m+1) và sau đó truy vết để tìm chuỗi con chung dài nhất.
public class Ex4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dãy X Hàng
        System.out.println("Nhap day X:");
        String lineX = sc.nextLine().replaceAll("[{},]", "");
        String[] partsX = lineX.trim().split("\\s+");

        // Nhập dãy Y Cột
        System.out.println("Nhap day Y:");
        String lineY = sc.nextLine().replaceAll("[{},]", "");
        String[] partsY = lineY.trim().split("\\s+");

        int n = partsX.length;
        int m = partsY.length;

        // Quy hoạch động: L[i][j] lưu độ dài của chuỗi con chung dài nhất giữa X[0..i-1] và Y[0..j-1], i hàng, j cột
        int[][] L = new int[n + 1][m + 1];

        // B1: Tính độ dài của chuỗi con chung dài nhất
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (partsX[i - 1].equals(partsY[j - 1])) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        // B2: Truy vết để tìm chuỗi con chung
        List<String> result = new ArrayList<>();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (partsX[i - 1].equals(partsY[j - 1])) {
                result.add(partsX[i - 1]); // Nếu bằng nhau thì đây là một phần tử chung
                i--; j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        Collections.reverse(result); // Đảo ngược lại vì truy vết từ cuối lên

        // In kết quả theo đinh dang (, , , )
        System.out.print("Output: (");
        for (int k = 0; k < result.size(); k++) {
            System.out.print(result.get(k) + (k == result.size() - 1 ? "" : ", "));
        }
        System.out.println(")");
    }
}
import java.util.Scanner;

public class Ex4_4 {
    public static int minOperations(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insertOp = dp[i][j - 1];
                    int removeOp = dp[i - 1][j];
                    int replaceOp = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insertOp, Math.min(removeOp, replaceOp));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();

        System.out.println(minOperations(s1, s2));
        scanner.close();
    }
}
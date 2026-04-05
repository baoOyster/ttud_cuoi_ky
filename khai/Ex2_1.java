import java.util.Scanner;

public class Ex2_1 {
    static int n;
    static int[] board;

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static void printSol() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println(" ");
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || abs(board[i] - col) == abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int row) {
        if (row == n) {
            printSol();
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                if (solve(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.err.println("Enter the size of board: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        if (!solve(0)) {
            System.out.println("No solution");
        }
    }
}
public class Ex2_2 {
    private static boolean isValid(int[][] board, int row, int col, int num) {
        //check hàng và cột
        for (int i=0; i<9; i++) {
            if (board[row][i]==num || board[i][col]==num) {
                return false;
            }
        }
        //check khối 3x3 ô
        int startRow = row - row%3;
        int startCol = col - col%3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[startRow+i][startCol+j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row=0; row<9; row++) {
            for (int col=0; col<9; col++) {
                if (board[row][col] == 0) {
                    for (int num=1; num<=9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Thử điền
                            //đệ quy giải tiếp
                            if (solveSudoku(board)) {
                                return true;
                            }
                            //nếu bế tắc, backtrack
                            board[row][col] = 0; 
                        }
                    }
                    return false; //nếu thử 1-9 không được->bế tắc
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r=0; r<9; r++) {
            if (r%3==0 && r!=0) {
                System.out.println("---------------------");
            }
            for (int c=0; c<9; c++) {
                if (c%3==0 && c!=0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // đề bài
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board)) {
            System.out.println("Đa giai xong :");
            printBoard(board);
        } else {
            System.out.println("Khong ton tai loi giai.");
        }
    }
}
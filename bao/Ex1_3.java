import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ex1_3 {
    static int n, k;
    static List<String> resultList = new ArrayList<>();
    static char[] currentStr;
    
    // Function to check if the generate string meets the condition
    static boolean checkValid(char[] s) {
        int countKBlocks = 0; // Counts blocks of exactly 'K' consecutive
        int currentALen = 0; // Tracks the current sequence of 'A's
    
        for(int i = 0; i < s.length; i++) {
            if (s[i] == 'A') {
                currentALen++;
            } else {
                if(currentALen == k) {
                    countKBlocks++;
                }
                currentALen = 0;
            }
        }

        // Check the last block if the string ends with 'A'
        if (currentALen == k) {
            countKBlocks++;
        }

        // Valid only if there is exactly ONE block of length K
        return countKBlocks == 1;
    }

    // Backtracking function
    static void generate(int index) {
        if (index == n) {
            if (checkValid(currentStr)) {
                resultList.add(new String(currentStr));
            }
            return;
        }

        // Try 'A' first, then 'B to maintain lexicographical order'
        currentStr[index] = 'A';
        generate(index + 1);

        currentStr[index] = 'B';
        generate(index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            k = scanner.nextInt();

            currentStr = new char[n];

            // Start generating from index 0
            generate(0);

            System.out.println(resultList.size());
            for(String s: resultList) {
                System.out.println(s);
            }

            scanner.close();
        }
    }
}

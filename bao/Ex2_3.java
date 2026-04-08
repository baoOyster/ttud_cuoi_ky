import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2_3 {
    static int[] arr;
    static int target;
    static boolean found = false;
    static List<Integer> result = new ArrayList<>();

    public static void backtrack(int index, int currentSum, List<Integer> subset) {
        if(found) return;

        if(currentSum == target) {
            found = true;
            result = new ArrayList<>(subset);
            return;
        }

        if(currentSum > target || index >= arr.length) return;

        subset.add(arr[index]);
        backtrack(index + 1, currentSum + arr[index], subset);
        subset.remove(subset.size() - 1);

        backtrack(index + 1, currentSum, subset);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine();
        String[] parts = line.trim().split(" ");
        arr = new int[parts.length];
        for(int i = 0; i < parts.length; i++)  arr[i] = Integer.parseInt(parts[i]);
        target = scanner.nextInt();
        scanner.close();
        backtrack(0, 0, new ArrayList<>());
        System.out.println(result);
    }
}
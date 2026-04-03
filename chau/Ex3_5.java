package chau;
import java.util.PriorityQueue;
import java.util.Scanner;
// Độ phức tạp tính toán là O(n log n) do chúng ta phải sắp xếp các dây và thực hiện các phép toán trên heap.
public class Ex3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of ropes: ");
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>(); // Min Heap
        System.out.println("Enter the lengths of the ropes:");
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        System.out.println("Initial Min Heap: " + pq);
        long cost = 0;

        while (pq.size() > 1) {
            long a = pq.poll();// Lấy phần tử nhỏ nhất
            long b = pq.poll();// Lấy phần tử nhỏ thứ hai
            long sum = a + b;
            cost += sum;
            System.out.println("Connect " + a + " + " + b + " = " + sum);

            pq.add(sum);//Đưa dây mới vào heap
            System.out.println("Heap after adding: " + pq);
        }
        System.out.println("Total cost: " + cost);
    }
}

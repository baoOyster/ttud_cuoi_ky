import java.util.Scanner;
public class Ex1_1 {
    static int n;
    static char[] arr;
    public static void printString() {
        for (int i = 0 ; i<n; i++){
            System.out.print(arr[i]);
        }
        System.out.println(" ");
    }
    public static void genAB(int idx){
        if (idx == n){
            printString();
            return;
        }
        arr[idx] = 'A';
        genAB(idx+1);
        arr[idx] = 'B';
        genAB(idx+1);
    }
    public static void main(String[] args) {
        System.err.println("Enter the length of the string: ");
        Scanner sc = new Scanner(System.in); 
        n = sc.nextInt();
        arr = new char[n];
        genAB(0);
    }
}
public class Ex4_1{
    public static void main(String[] args){
    int[] A = {10,22,9,33,21,50,41,60};
    int n= A.length;
    int[] dp = new int[n];
    int[] data = new int[n];
    for(int i=0; i<n; i++){
        dp[i]=1;
        data[i]=-1;
    }
    int maxLen=1;
    int maxNumPos=0;
    for(int i=1;i<n;i++){
        for(int j=0 ; j<i; j++){
            if(A[j]<A[i]){
                if(dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    data[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen = dp[i];
                maxNumPos = i;
            }
        }
    }
    System.out.println("The longest increasing sequence is: " + maxLen);
    System.out.println("it is: ");
    printSequence(A, data, maxNumPos);
    }
    public static void printSequence(int[] A, int[] data, int pos){
        if(pos == -1){
            return;
        }
        printSequence(A, data, data[pos]);
        System.out.print(A[pos] + " ");
    }
}
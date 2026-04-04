// tư tưởng: trong 1 quán ăn việc thiếu tiền lẻ xảy ra rất thường xuyên do vậy với bài toán này như bản năng của người thu nghân/tính tiền sẽ ưu tiên trả tiền có mệnh gióa lớn nhất có thể sao cho số lượng tiền trả cho khách hàng là ít nhất nhưng vẫn tạo ra đủ số tiền thối n(với dụ thối 15k thay vì 3 tờ 5k sẽ trả 1 tờ 10k và 1 tờ 5k)

// cụ thể trong bài toán này :
// bước 1 khai báo 1 mảng với tất cả số tiền đang có với mệnh giá giảm dần
// bước 2 lấy N số tiền cần xử lý chia cho lần lượt các mệnh giá xem có thể sử dụng tối đa bao nhiêu tờ tiền 
// bước 3 chia lấy đi số tiền vừa được xử lý và tiếp tục lấy phần dư vừa chia đó chia cho các mệnh giá tiếp theo cho đến khi hết số tiền cần xử lý(sô tiền cần xử lý = 0)

import java.util.Scanner;

public class Ex3_1{
    static int[] money = {500, 100, 50, 10, 5 , 1};
    static int N;
    public static void processMoney(){
        for(int i=0; i<money.length; i++){
            if(N>= money[i]){
                int numOfMoney = N/money[i];
                System.out.println( money[i] + "$ " + numOfMoney + " cháu");
                N = N%money[i];
            }
            
        }
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of money to be processed: ");
        while(true){
            N = sc.nextInt();
            if (N < 0||N>999){
                System.out.println("Invalid input, please enter a non-negative integer between 0 and 999.");
                continue;
            }
            break;
        }  
        processMoney();
    }
}

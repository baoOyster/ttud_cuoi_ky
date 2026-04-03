package chau;
import java.util.*;
//Độ phức tạp thời gian O(N log N) do chúng ta phải sắp xếp các công việc theo thời gian kết thúc và sau đó duyệt qua danh sách đã sắp xếp một lần để chọn các công việc không trùng lặp.
//Độ phức tap không gian O(N) do chúng ta lưu trữ danh sách các công việc và một số biến phụ trợ khác.
public class Ex3_4 {
    static class Job {
        int start, end;
        Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong cong viec N: ");
        // Nhập số lượng công việc N
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] f = new int[n];
            
            // Nhập mảng thời gian bắt đầu
            System.out.println("Nhap thoi gian Start cua cac cong viec:");
            for (int i = 0; i < n; i++) s[i] = sc.nextInt();
            // Nhập mảng thời gian kết thúc
            System.out.println("Nhap thoi gian Finish cua cac cong viec:");
            for (int i = 0; i < n; i++) {
                int finish = sc.nextInt();
                // Kiem tra logic: Finish phai >= Start
                 while (finish < s[i]) {
                    System.out.println("Loi: Thoi gian ket thuc phai >= " + s[i] + ". Moi nhap lai cho cong viec " + (i+1) + ":");
                    finish = sc.nextInt();
                }
                f[i] = finish;
            }
            
            List<Job> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                jobs.add(new Job(s[i], f[i]));
            }
            
            // Chiến thuật: Sắp xếp công việc theo thời gian KẾT THÚC tăng dần
            // Việc nào kết thúc "càng sớm" thì càng ưu tiên chọn trước
            Collections.sort(jobs, (a, b) -> a.end - b.end);
            
            int count = 0;
            int lastEndTime = -1; // Lưu mốc thời gian kết thúc của công việc vừa chọn
            
            for (Job job : jobs) { // Không chồng lấp: Chọn công việc tiếp theo nếu thời gian bắt đầu của nó >= thời gian kết thúc của công việc vừa r
                if (job.start >= lastEndTime) {
                    count++; // Chọn công việc này
                    lastEndTime = job.end; // Cập nhật mốc kết thúc mới
                }
            }
            System.out.println("So luong cong viec duoc chon: " + count);
        }
        sc.close();
    }
}
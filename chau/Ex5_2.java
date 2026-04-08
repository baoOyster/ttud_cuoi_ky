package chau;
import java.util.*;
//Độ phức tạp thời gian O(V + E) với V là số đỉnh và E là số cạnh của đồ thị, do chúng ta duyệt qua tất cả các đỉnh và cạnh một lần trong quá trình BFS.
//Độ phức tạp không gian O(V) do chúng ta cần lưu trữ thông tin về các đỉnh đã thăm và hàng đợi trong quá trình duyệt.
public class Ex5_2 {
    public static void main(String[] args) {
        // 1. Khai báo đồ thị dưới dạng danh sách kề (Map)
        Map<String, List<String>> adj = new TreeMap<>();
        
        adj.put("a", Arrays.asList("e", "f", "g", "i"));
        adj.put("b", Arrays.asList("g"));
        adj.put("e", Arrays.asList("a", "f", "i"));
        adj.put("f", Arrays.asList("a", "e", "i"));
        adj.put("g", Arrays.asList("a", "b"));
        adj.put("i", Arrays.asList("a", "e", "f"));

        // Sắp xếp danh sách hàng xóm của mỗi đỉnh theo thứ tự bảng chữ cái để đảm bảo kết quả duyệt BFS có thứ tự đúng
        for (List<String> neighbors : adj.values()) {
            Collections.sort(neighbors);
        }

        System.out.print("Ket qua duyet BFS bat dau tu dinh 'a': ");
        bfs(adj, "a");
    }

    public static void bfs(Map<String, List<String>> adj, String startNode) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Bắt đầu từ đỉnh startNode
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // Lấy các hàng xóm của đỉnh hiện tại và thêm vào hàng đợi nếu chưa được thăm
            List<String> neighbors = adj.get(currentNode);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }
}

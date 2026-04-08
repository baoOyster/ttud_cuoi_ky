import java.util.*;
public class Ex5_1 {
    public static void dfsVisit(String u, Map<String, List<String>> adjList, Set<String> visited){
        //đã thăm 
        visited.add(u);
        System.out.print(u+" ");
        // đỉnh kề của u
        List<String> neighbors=adjList.getOrDefault(u, new ArrayList<>());
        // sắp xếp theo bảng chữ cái 
        Collections.sort(neighbors);                      
        //đỉnh chưa thăm của u
        for (String v : neighbors){
            if (!visited.contains(v)){
                dfsVisit(v, adjList, visited); 
            }
        }
    }
    public static void main(String[] args) {
        //đề bài
        Map<String, List<String>> graph=new HashMap<>();
        graph.put("a", Arrays.asList("e", "f", "g", "i"));
        graph.put("b", Arrays.asList("g"));
        graph.put("e", Arrays.asList("a", "f", "i"));
        graph.put("f", Arrays.asList("a", "e", "i"));
        graph.put("g", Arrays.asList("a", "b"));
        graph.put("i", Arrays.asList("a", "e", "f"));

        Set<String> visited=new HashSet<>();
        System.out.print("Thu tu duyet DFS: ");
        //lấy all đỉnh 
        List<String> allVertices=new ArrayList<>(graph.keySet());
        Collections.sort(allVertices);
        for (String vertex : allVertices){
            if (!visited.contains(vertex)){
                dfsVisit(vertex, graph, visited);
            }
        }
    }
}
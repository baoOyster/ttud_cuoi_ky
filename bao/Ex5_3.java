import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Ex5_3 {
    static void topologicalSort(int V, List<List<Integer>> adjList) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int adjacent: adjList.get(i)) {
                indegree[adjacent]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            topologicalOrder.add(current);

            for (int adjacent : adjList.get(current)) {
                indegree[adjacent]--;

                if(indegree[adjacent] == 0) {
                    queue.add(adjacent);
                }
            }
        }

        if (topologicalOrder.size() != V) {
            System.out.println("The graph contains a cycle, topological sorting not possible.");
        } else {
            System.out.println("Topological sort: " + topologicalOrder);
        }
    }

    public static void main(String[] args) {
        int V = 6; 
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(5).add(0);
        adjList.get(5).add(2);
        
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        
        adjList.get(2).add(3);
        
        adjList.get(3).add(1);

        topologicalSort(V, adjList);
    }
}
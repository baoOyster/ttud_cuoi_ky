import java.util.Scanner;

public class Ex3_6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        final int INF = 1_000_000_000;
        
        int[][] graph = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for(int k = 0; k < m; k++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            graph[u][v] = c;
        }

        boolean[] visited = new boolean[n + 1];
        int currentCity = 1;
        visited[currentCity] = true;
        
        long totalCost = 0;

        for(int step = 1; step < n; step++) {
            int nextCity = -1;
            int minCost = INF;

            for (int v = 1; v <= n; v++) {
                if(!visited[v] && graph[currentCity][v] <  minCost) {
                    minCost = graph[currentCity][v];
                    nextCity = v;
                }
            }

            if(nextCity == -1) {
                System.out.println("No valid route exists");
                scanner.close();
                return;
            }

            visited[nextCity] = true;
            totalCost += minCost;
            currentCity = nextCity;
        }

        if(graph[currentCity][1] == INF) {
            System.out.println("No route back to the starting city exists.");
        } else {
            totalCost += graph[currentCity][1];
            System.out.println(totalCost);
        }

        scanner.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited[1] = true;
        
        dfs(1);

        System.out.println(ans);
        
    }

    static void dfs(int vertex) {
        
        for (int currV = 1; currV <= n; currV++) {
            if (graph[vertex][currV] == 1 && !visited[currV]) {
                ans++;
                visited[currV] = true;
                dfs(currV);
            }
        }
    }
}
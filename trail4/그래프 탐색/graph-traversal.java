import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited[1] = true;
        
        dfs(1);

        System.out.println(ans);
    }

    static void dfs(int vertex) {
        
        for (int currV : graph[vertex]) {
            if (!visited[currV]) {
                visited[currV] = true;
                ans++;
                dfs(currV);
            }
        }
    }
}
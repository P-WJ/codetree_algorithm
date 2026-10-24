import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Edge>[] graph;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        System.out.println(prim(1));
    }

    static long prim(int start) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        long total = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            total += cur.weight;
            cnt++;
            if (cnt == n) break;

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }
        return total;
    }
}
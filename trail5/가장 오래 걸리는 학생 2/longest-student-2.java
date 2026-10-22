import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static List<Edge>[] graph;
    static int[] dist;
    
    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight =weight;
    }

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
        dist = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[b].add(new Edge(a, d));
        }
        
        ans = 0;

        dijkstra(n);

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.weight;

            if (cost > dist[now]) continue;
            
            for (Edge next : graph[now]) {
                int newCost = cost + next.weight;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }
}
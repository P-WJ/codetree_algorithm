import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static List<Edge>[] graph;
    static int[] dist;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
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
        k = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        dist = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        dijkstra(k);

        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
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
                int newCost = dist[now] + next.weight;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }

    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Edge>[] graph;
    static int[] dist, path;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        path = new int[n+1];

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

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        dijkstra(a, 0);

        sb.append(dist[b]).append('\n');

        List<Integer> route = new ArrayList<>();
        int cur = b;
        
        while(cur != a) {
            route.add(cur);
            cur = path[cur];
        }
        route.add(a);

        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i)).append(' ');
        }
        
        System.out.println(sb);
    }

    static void dijkstra(int start, int weight) {

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
                    path[next.to] = now;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }
}
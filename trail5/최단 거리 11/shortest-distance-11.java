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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
        }
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        dijkstra(b);

        sb.append(dist[a]).append('\n');


        int cur = a;
        sb.append(a).append(' ');

        while (cur != b) {
            cur = path[cur];
            sb.append(cur).append(' ');
        }

        System.out.print(sb);

    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.weight;

            if (dist[now] < cost) continue;

            for (Edge next : graph[now]) {
                int newCost = cost + next.weight;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    path[next.to] = now;
                    pq.offer(new Edge(next.to, newCost));
                } else if (newCost == dist[next.to] && now < path[next.to]) {
                    path[next.to] = now;
                }
            }
        }
    }
}
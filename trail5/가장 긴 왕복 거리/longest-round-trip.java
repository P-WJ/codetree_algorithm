import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static List<Edge>[] graph1, graph2;

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
        x = Integer.parseInt(st.nextToken());
        graph1 = new ArrayList[n+1];
        graph2 = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph1[a].add(new Edge(b, w));
            graph2[b].add(new Edge(a, w));
        }

        int[] dist1 = dijkstra(x, graph1);
        int[] dist2 = dijkstra(x, graph2);

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.print(ans);
        
    }

    static int[] dijkstra(int start, List<Edge>[] graph) {
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
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
        return dist;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent, size;
    static Edge[] edges;

    static class Edge implements Comparable<Edge> {
        int a, b, weight;

        Edge (int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
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

        edges = new Edge[m];
        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
        
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges);

        long total = 0;
        int cnt = 0;

        for (Edge e : edges) {
            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            total += e. weight;
            cnt++;

            if (cnt == n-1) break;
        }
        System.out.println(total);
    }

    static int find(int x) {
        
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return;

        if (size[aRoot] < size[bRoot]) {
            parent[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            parent[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
    }
}
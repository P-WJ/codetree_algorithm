import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int)1e9;
    static int n, m, v1, v2, e;
    static int[][] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        mat = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    mat[i][j] = INF;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            mat[x][y] = Math.min(mat[x][y], z);
            mat[y][x] = Math.min(mat[y][x], z);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (mat[i][k] == INF) continue;
                for (int j = 1; j <= n; j++) {
                    if (mat[k][j] == INF) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        long ans = Long.MAX_VALUE;

        for (int k = 1; k <= n; k++) {
            if (mat[v1][k] == INF || mat[v2][k] == INF || mat[k][e] == INF) continue;
            long cost = mat[v1][k] + mat[v2][k] + mat[k][e];
            ans = Math.min(ans, cost);
        }

        if (ans == Long.MAX_VALUE) ans = -1;
        
        sb.append(ans);
        System.out.print(sb);
    }
}
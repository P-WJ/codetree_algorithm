import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    mat[i][j] = (int)1e9;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            mat[u][v] = Math.min(mat[u][v], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (mat[i][k] == (int)1e9) continue;
                for (int j = 1; j <= n; j++) {
                    if (mat[k][j] == (int)1e9) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        int ans = (int)1e9;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (mat[i][j] == (int)1e9 || mat[j][i] == (int)1e9) continue;
                ans = Math.min(ans, mat[i][j] + mat[j][i]);
            }
        }
        System.out.println(ans);
    }
}
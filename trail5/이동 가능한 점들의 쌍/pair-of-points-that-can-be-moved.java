import java.io.*;
import java.util.*;

public class Main {
    static int n, m, p, q;
    static int[][] matrix;
    static int[] a, b;
    static boolean[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        matrix = new int[n+1][n+1];
        a = new int[q];
        b = new int[q];
        nums = new boolean[n+1];

        for (int i = 1; i <= p; i++) {
            nums[i] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                matrix[i][j] = (int)1e9; 
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            matrix[u][v] = Math.min(matrix[u][v], w);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (matrix[i][k] == (int)1e9) continue;
                for (int j = 1; j <= n; j++) {
                    if (matrix[k][j] == (int)1e9) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        int cnt = 0;
        long cost = 0;
        for (int i = 0; i < q; i++) {
            long best = Long.MAX_VALUE;
            
            for (int r = 1; r <= p; r++) {
                if (matrix[a[i]][r] == (int)1e9 || matrix[r][b[i]] == (int)1e9) continue;
                best = Math.min(best, matrix[a[i]][r] + matrix[r][b[i]]);
            }

            if (best != Long.MAX_VALUE) {
                cnt++;
                cost += best;
            }
        }

        sb.append(cnt).append('\n').append(cost);
        System.out.print(sb);
    }
}


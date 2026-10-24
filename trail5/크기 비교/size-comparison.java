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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (mat[i][k] == 0) continue;
                for (int j = 1; j <= n; j++) {
                    if (mat[k][j] == 0) continue;
                    mat[i][j] = 1;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (mat[i][j] == mat[j][i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
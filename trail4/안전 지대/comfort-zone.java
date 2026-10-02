import java.io.*;
import java.util.*;

public class Main {

    static int n, m, K, ans, level;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = 0;
        ans = 0;
        level = 1;
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > K) {
                    K = grid[i][j];
                }
            }
        }
        for (int k = 1; k <= K; k++) {
            int cnt = 0;
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (grid[i][j] <= k || visited[i][j]) continue;
                    dfs(k, i, j);
                    cnt++;
                }
            }  
            if (cnt > ans) {
                ans = cnt;
                level = k;
            }
        }

        System.out.println(level + " " + ans);
    }

    static void dfs(int k, int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] <= k) continue;

            visited[nr][nc] = true;
            
            dfs(k, nr, nc);
        }

    }
}
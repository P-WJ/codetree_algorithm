import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;

        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int r, int c) {

        if (r == n-1 && c == m-1) {
            ans = 1;
            return;
        }

        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] == 0) continue;

            grid[nr][nc] = grid[r][c] + 1;
            visited[nr][nc] = true;
            
            dfs(nr, nc);
        }
    }
}
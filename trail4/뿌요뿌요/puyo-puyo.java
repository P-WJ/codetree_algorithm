import java.io.*;
import java.util.*;

public class Main {

    static int n, ans, cnt;
    
    static int[][] grid;
    static boolean[][] visited;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                
                visited[i][j] = true;

                int size = dfs(grid[i][j], i, j);

                if (size >= 4) {
                    cnt++;
                }

                ans = Math.max(ans, size);
            }
        }

        System.out.println(cnt + " " + ans);
    }

    static int dfs(int cur, int r, int c) {

        int size = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] != cur) continue;

            visited[nr][nc] = true;

            size += dfs(cur, nr, nc);
        }

        return size;
    }
}
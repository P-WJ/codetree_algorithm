import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i][0] = Integer.parseInt(st.nextToken()) - 1;
            starts[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int ans = k;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            q.offer(starts[i]);
            grid[starts[i][0]][starts[i][1]] = 1;
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (grid[nx][ny] == 1) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                grid[nx][ny] = 1;
                ans++;
            }
        }
      
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            if (x == n-1 && y == m-1) {
                System.out.println(1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
            
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (grid[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        System.out.println(0);
    }
}
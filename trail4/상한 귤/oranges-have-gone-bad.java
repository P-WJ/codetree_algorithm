import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[][] grid;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][]dist;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }


        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (grid[x][y] == 2) {
                grid[x][y] = 0;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] != 1) {
                    continue;
                }

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                
                dist[nx][ny] = dist[x][y] + 1;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dist[i][j] = -1;
                } 
                else if (grid[i][j] == 1 && !visited[i][j]) {
                    dist[i][j] = -2;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }


    }
}
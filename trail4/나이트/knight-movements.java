import java.util.*;
import java.io.*;

public class Main {

    static int n, r1, c1, r2, c2;
    static int[][] grid;
    static boolean flag;

    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()) - 1;
        int c1 = Integer.parseInt(st.nextToken()) - 1;
        int r2 = Integer.parseInt(st.nextToken()) - 1;
        int c2 = Integer.parseInt(st.nextToken()) - 1;

        grid = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{r1, c1});
        grid[r1][c1] = 0;

        if (r1 == r2 && c1 == c2) {
            System.out.println(0);
            } else {
                while (!q.isEmpty()) {
            
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (grid[nx][ny] != 0) {
                        continue;
                    }

                    grid[nx][ny] += grid[x][y] + 1;

                    if (nx == r2 && ny == c2) {
                        flag = true;
                        break;
                    }

                    q.offer(new int[]{nx, ny});
                }
            }

            if (grid[r2][c2] == 0 && !flag) {
                System.out.println(-1);
            } else {
                System.out.println(grid[r2][c2]);
            }
        }
    }
}
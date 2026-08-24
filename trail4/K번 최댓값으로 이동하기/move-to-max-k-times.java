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

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int move = 0; move < k; move++) {
            
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];

            q.offer(new int[]{r, c});
            visited[r][c] = true;

            int maxValue = -1;
            int maxX = -1;
            int maxY = -1;

            while (!q.isEmpty()) {

                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (visited[nx][ny]) {
                        continue;
                    }

                    if (grid[nx][ny] >= grid[r][c]) {
                        continue;
                    }

                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;

                    if (maxValue < grid[nx][ny]) {
                        maxValue = grid[nx][ny];
                        maxX = nx;
                        maxY = ny;
                    } else if (maxValue == grid[nx][ny]) {
                        if (maxX > nx || (maxX == nx && maxY > ny)) {
                            maxX = nx;
                            maxY = ny;
                        }
                    }
                }
            }

            if (maxX == -1) {
                break;
            }

            r = maxX;
            c = maxY;
        }

        System.out.println((r+1) + " " + (c+1));
    }
}
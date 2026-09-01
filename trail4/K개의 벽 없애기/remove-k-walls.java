import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[][] grid;
    static List<int[]> selected = new ArrayList<>();

    static int r1, c1, r2, c2;

    static int[] dx = {1, -1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        select(0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void select(int start) {

        if (selected.size() == k) {
            int result = bfs();
            if (result != 0) {
                ans = Math.min(ans, result);
            }
            
            return;
        }

        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (grid[x][y] != 1) {
                continue;
            }

            selected.add(new int[]{x, y});

            select(i + 1);

            selected.remove(selected.size() - 1);
        }
    }

    static int bfs() {

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < selected.size(); i++) {
            int x = selected.get(i)[0];
            int y = selected.get(i)[1];

            grid[x][y] = 0;
        }

        q.offer(new int[]{r1, c1});
        visited[r1][c1] = true;

        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == r2 && y == c2) {
                break;
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

                if (grid[nx][ny] == 1) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < selected.size(); i++) {
            int x = selected.get(i)[0];
            int y = selected.get(i)[1];

            grid[x][y] = 1;
        }

        return dist[r2][c2];
    }
    
}
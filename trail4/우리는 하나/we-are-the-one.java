import java.util.*;
import java.io.*;

public class Main {

    static int n, k, u, d, ans;

    static int[][] grid;
    static List<int[]> selected = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select(0);
        System.out.println(ans);
    
    }

    static void select(int start) {

        if (selected.size() == k) {
            ans = Math.max(ans, bfs(selected));
            return;
        }

        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            selected.add(new int[]{x, y});

            select(i+1);

            selected.remove(selected.size() - 1);
        }
        
    }


    static int bfs(List<int[]> selected) {
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        int cnt = selected.size();

        for (int i = 0; i < selected.size(); i++) {
            int x = selected.get(i)[0];
            int y = selected.get(i)[1];
            q.offer(new int[]{x, y});
            visited[x][y] = true;
        }
        


        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (Math.abs(grid[nx][ny] - grid[x][y]) >= u && Math.abs(grid[nx][ny] - grid[x][y]) <= d) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;

    }
}
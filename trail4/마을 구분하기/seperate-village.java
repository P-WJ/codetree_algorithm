import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> li = new ArrayList<>();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(i, j);
                    li.add(cnt);
                    ans++;
                }
            }
        }

        Collections.sort(li);

        System.out.println(ans);
        for(int c : li) {
            System.out.println(c);
        }
        
    }

    static int bfs(int i, int j) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int cnt = 1;
        
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

                if (grid[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        return cnt;
    }
}
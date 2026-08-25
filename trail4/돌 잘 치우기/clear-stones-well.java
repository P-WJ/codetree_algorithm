import java.util.*;
import java.io.*;

public class Main {

    static int n, k, m;
    static int[][] grid;
    static int[][] startPoints;

    static List<int[]> stones = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int ans = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n: 격자 크기, k: 시작점 개수, m: 돌 제거 가능 개수
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 격자
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                // 돌 좌표
                if (grid[i][j] == 1) {
                    stones.add(new int[]{i, j});
                }
            }
        }

        // 시작점
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            startPoints[i][0] = Integer.parseInt(st.nextToken()) - 1;
            startPoints[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        chooseStones(0, 0);

        System.out.println(ans);

    }

    static void chooseStones(int start, int cnt) {

        if (cnt == m) {

            int result = bfs();
            ans = Math.max(ans, result);

            return;
        }

        for (int i = start; i < stones.size(); i++) {

            int x = stones.get(i)[0];
            int y = stones.get(i)[1];

            grid[x][y] = 0;

            chooseStones(i + 1, cnt + 1);

            grid[x][y] = 1;
        }
    }

    static int bfs() {
        
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < k; i++) {
            int x = startPoints[i][0];
            int y = startPoints[i][1];
            visited[x][y] = true;
            q.offer(new int[]{x, y});
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            cnt++;

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

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }
}
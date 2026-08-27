import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static Queue<int[]> q = new ArrayDeque<>();
    static List<int[]> melt = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int time = 0;

        while (true) {
            
            int melted = bfs();

            if (melted == 0) {
                break;
            }

            cnt = melted;
            time++;
        }

        System.out.println(time + " " + cnt);
    }

    static int bfs() {
        
        visited = new boolean[n][m];
        q.clear();
        melt.clear();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
            
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }

                if (grid[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    melt.add(new int[]{nx, ny});
                }
            }
        }

        for (int[] m : melt) {
            grid[m[0]][m[1]] = 0;
        }
        return melt.size();
    }
}
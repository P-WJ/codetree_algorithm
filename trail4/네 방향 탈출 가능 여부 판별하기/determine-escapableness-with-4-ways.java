import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
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
                q.add(new int[]{nx, ny});
            }
        }

        if (visited[n-1][m-1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] a;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0});
        a[0][0] = 0;

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

                if (a[nx][ny] != 1) {
                    continue;
                }

                a[nx][ny] += a[x][y];
                q.offer(new int[]{nx, ny});
            }
        }

        if (a[n-1][m-1] == 1) {
            System.out.println(-1);
        } else {
            System.out.println(a[n-1][m-1]);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n, h, m;
    static int[][] a;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        
        int[][] ans = new int[n][n];
        List<int[]> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 2) {
                    people.add(new int[]{i, j});
                }
            }
        }

        for (int[] p : people) {

            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            
            q.offer(new int[]{p[0], p[1]});
            visited[p[0]][p[1]] = true;
            
            int[][] dist = new int[n][n];
        
            boolean flag = false;
            int cnt = 0;

            while (!q.isEmpty() && !flag) {

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

                    if (a[nx][ny] == 1) {
                        continue;
                    }
              
                    q.offer(new int[]{nx, ny});

                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;

                    if (a[nx][ny] == 3) {
                        flag = true;
                        ans[p[0]][p[1]] = dist[nx][ny];
                        break;
                    }
                }
            }
            if (!flag) {
                ans[p[0]][p[1]] = -1;  
            } 
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
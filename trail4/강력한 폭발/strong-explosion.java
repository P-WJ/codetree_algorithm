import java.util.*;
import java.io.*;

public class Main {

    static int n, ans;
    static int[][] grid;
    static boolean[][] visited;
    static List<int[]> bomb;
    static int[] selected;

    static int[] a_dir = {2, 1, 0, -1, -2};
    static int[] b_dir1 = {1, -1, 0, 0};
    static int[] b_dir2 = {0, 0, 1, -1};
    static int[] c_dir1 = {1, 1, -1, -1};
    static int[] c_dir2 = {1, -1 ,1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        
        bomb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    bomb.add(new int[]{i, j});
                }
            }
        }

        selected = new int[bomb.size()];

        select(0);

        System.out.println(ans);        
    }

    static void select(int idx) {

        if (idx == bomb.size()) {
            visited = new boolean[n][n];

            for (int i = 0; i < bomb.size(); i++) {
                int r = bomb.get(i)[0];
                int c = bomb.get(i)[1];

                if (selected[i] == 1) {
                    a(r, c);
                } else if (selected[i] == 2) {
                    b(r, c);
                } else {
                    c(r, c);
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);

            return;
        }

        for (int i = 1; i <= 3; i++) {
            selected[idx] = i;
            select(idx + 1);
        }


    }

    // 세로 폭탄
    static void a(int r, int c) {

        visited[r][c] = true;
        
        for (int d = 0; d < 5; d++) {
            int nr = r + a_dir[d];
            if (nr < 0 || nr >= n) {
                continue;
            }
            visited[nr][c] = true;
        }
    }

    // 십자 폭탄
    static void b(int r, int c) {

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + b_dir1[d];
            int nc = c + b_dir2[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            visited[nr][nc] = true;
        }
    }

    // x자 폭탄
    static void c(int r, int c) {

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + c_dir1[d];
            int nc = c + c_dir2[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            visited[nr][nc] = true;
        }
    }
}
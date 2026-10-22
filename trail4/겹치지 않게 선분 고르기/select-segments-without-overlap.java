import java.util.*;
import java.io.*;

public class Main {
    static int n, ans;
    static int[][] segments;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        segments = new int[n][2];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
        }

        ans = 0;

        dfs(0, 0);

        sb.append(ans).append('\n');
        System.out.print(sb);
    }

    static void dfs(int idx, int cnt) {

        if (idx == n) {
            ans = Math.max(ans, cnt);
            return;
        }

        dfs(idx + 1, cnt);

        boolean possible = true;

        for (int i = 0; i < idx; i++) {
            if (selected[i]) {
                if (segments[i][0] <= segments[idx][1] && segments[idx][0] <= segments[i][1]) {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            selected[idx] = true;
            dfs(idx + 1, cnt + 1);
            selected[idx] = false;
        }
    }
 }

import java.util.*;
import java.io.*;

public class Main {
    
    static int n;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[1000001];
        int[] dist = new int[1000001];

        q.offer(n);
        visited[n] = true;
        int ans = 0;

        while (!q.isEmpty()) {


            int x = q.poll();

            if (x == 1) {
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx;
                
                if (d == 0) {
                    nx = x - 1;
                }

                else if (d == 1) {
                    nx = x + 1;
                }

                else if (d == 2) {
                    if (x % 2 != 0) {
                        continue;
                    }
                    nx = x / 2;
                }

                else {
                    if (x % 3 != 0) {
                        continue;
                    }
                    nx = x / 3;
                }

                if (nx < 0 || nx > 1000000) {
                    continue;
                }

                if (visited[nx]) {
                    continue;
                }

                q.offer(nx);
                visited[nx] = true;
                dist[nx] = dist[x] + 1;

            }
        }

        System.out.println(dist[1]);
        
    }
}
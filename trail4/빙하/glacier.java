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

        int last = 0;
        int time = 0;

        while (true) {
            
            int melted = bfs();

            if (melted == 0) {
                break;
            }

            last = melted;
            time++;
        }

        System.out.println(time + " " + last);


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

// from collections import deque

// n, m = map(int, input().split())
// a = [list(map(int, input().split())) for _ in range(n)]

// # Please write your code here.
// dir = [[1,0], [-1,0], [0,1], [0,-1]]

// def bfs():
//     visited = [[False] * m for _ in range(n)]
//     q = deque()
//     melt = []
//     q.append((0,0))
//     visited[0][0] = True
    
//     while q:
//         x, y = q.popleft()

//         for dx, dy in dir:
//             nx = x + dx
//             ny = y + dy

//             if 0 <= nx < n and 0 <= ny < m:
//                 if not visited[nx][ny]:

//                     if a[nx][ny] == 0:
//                         visited[nx][ny] = True
//                         q.append((nx,ny))

//                     elif a[nx][ny] == 1:
//                         visited[nx][ny] = True
//                         melt.append((nx,ny))

//     for x, y in melt:
//         a[x][y] = 0

//     return len(melt)

// last = 0
// time = 0

// while True:
//     melted = bfs()
//     if  melted == 0:
//         break

//     last = melted
//     time += 1

// print(time, last)

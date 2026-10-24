import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        points = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(upperBound(b) - lowerBound(a)).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int x) {
    
        int left = 0;
        int right = n - 1;
        int minIdx = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (points[mid] >= x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    static int upperBound(int x) {
    
        int left = 0;
        int right = n - 1;
        int minIdx = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (points[mid] > x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }
}
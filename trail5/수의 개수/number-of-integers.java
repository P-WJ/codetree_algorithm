import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(upperBound(x) - lowerBound(x)).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int x) {

        int left = 0;
        int right = n - 1;
        int minIdx = n;

        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            if (arr[mid] >= x) {
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
            
            if (arr[mid] > x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);

            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, queries;
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
        
        queries = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(lowerBound(x)).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int x) {
        
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        boolean flag = false;

        while (left <= right) {
            
            int mid = (left + right) / 2;

            if (arr[mid] >= x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
                if (arr[mid] == x) {
                    flag = true;
                }
            } else { 
                left = mid + 1;
            }
        }
        if (!flag) return -1;
        return minIdx + 1;
    }
}
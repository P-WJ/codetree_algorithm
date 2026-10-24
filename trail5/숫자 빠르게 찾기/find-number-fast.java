import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
           System.out.println(f(x));
        }
    }

    static int f(int x) {
        
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }
}
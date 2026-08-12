import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            k = Math.max(k, String.valueOf(num).length());
        }
        // Please write your code here.

        for (int pos = 0; pos < k ; pos++) {

            int[][] buckets = new int[10][n];

            int[] cnt = new int[10];

            for (int i = 0; i < n; i++) {
                int digit = (arr[i] / (int) Math.pow(10, pos)) % 10;
                
                buckets[digit][cnt[digit]] = arr[i];
                cnt[digit]++;
            }

            int idx = 0;
            
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    arr[idx] = buckets[i][j];
                    idx++;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int ans = Integer.MAX_VALUE;

        for (int l = 0; l <= 10000; l++) {
            
            int r = l + k;
            int cost = 0;
            
            for(int x : arr) {
                if (x < l) {
                    cost += l - x;
                } else if (x > r) {
                    cost += x - r;
                }
            }

            ans = Math.min(ans, cost);
        }
        System.out.println(ans);
    }
}
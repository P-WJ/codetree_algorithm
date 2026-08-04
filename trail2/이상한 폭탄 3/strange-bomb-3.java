import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();
        // Please write your code here.


        int ans = 0;
        int maxCnt = 0;
        
        for (int i = 0; i < n; i++) {
            
            boolean explode = false;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (bombs[i] == bombs[j] && Math.abs(i-j) <= k) {
                    explode = true;
                    break;
                }
            }

            if (!explode) {
                continue;
            }

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (bombs[i] == bombs[j]) {
                    cnt++;
                }
            }
            
            if (maxCnt < cnt) {
                maxCnt = cnt;
                ans = bombs[i];
            } else if (maxCnt == cnt && ans < bombs[i]) {
                ans = bombs[i];
            }
            

        }
        System.out.println(ans);
        
    }
}
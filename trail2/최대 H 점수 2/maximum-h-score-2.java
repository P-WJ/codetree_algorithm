import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // Please write your code here.

        int ans = 0;

        for (int i = 0; i <= 100; i++) {

            int cnt = 0;
            int cntl = 0;

            for (int j = 0; j < n; j++) {
                if (a[j] >= i) {
                    cnt++;
                    
                } else if (a[j] + 1 >= i){
                    if (cntl < l) {
                        cntl++;
                        cnt++;
                    }
                }
            }

            if (cnt >= i) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
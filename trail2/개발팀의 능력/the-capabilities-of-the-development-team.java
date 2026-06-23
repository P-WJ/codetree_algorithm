import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        int ans = Integer.MAX_VALUE;
        boolean f = false;

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += arr[i];
        }

        for (int i = 0; i < 5; i++) {
            int sum1 = arr[i];

            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < 5; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    int sum2 = arr[j] + arr[k];
                    int sum3 = total - (sum1 + sum2);

                    if (sum1 == sum2 || sum2 == sum3 || sum3 == sum1) {
                        f = false;
                        break;
                    }
                    ans = Math.min(ans, Math.max(sum1, Math.max(sum2, sum3)) - Math.min(sum1, Math.min(sum2, sum3)));
                    f = true;
                }
            }
        }

        if (f) {
            System.out.println(ans);
        }
        else {
            System.out.println(-1);
        }
    }
}
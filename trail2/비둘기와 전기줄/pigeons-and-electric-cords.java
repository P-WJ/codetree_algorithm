import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[11];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();

            if (arr[p] == 0) {
                arr[p] = d+1;
            } else if (arr[p] != d+1) {
                ans++;
                arr[p] = d+1;
            }
        }

        System.out.println(ans);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        // Please write your code here.

        int ans = 0;
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            prefix += a[i] - b[i];
            ans += prefix;
        }
    System.out.println(ans);
    }
}
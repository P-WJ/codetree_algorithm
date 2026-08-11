import java.util.Scanner;
public class Main {

    static int n;
    static int ans = 0;

    static void f(int idx) {
        
        if (idx == n) {
            ans++;
            return;
        }

        for (int num = 1; num <= 4; num++) {
            if (idx + num <= n) {
                f(idx + num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.

        f(0);

        System.out.println(ans);
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        int ans = 0;

        if (b-a == 1 && c-b == 1) {
            ans = 0;
        } else {
            ans = Math.max(b-a-1, c-b-1);
        }

        System.out.println(ans);
    }
}
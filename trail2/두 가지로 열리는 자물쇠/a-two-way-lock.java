import java.util.Scanner;

public class Main {
    
    static int n;

    public static boolean f(int x, int y) {
        return Math.abs(x-y) <= 2 || (n - Math.abs(x-y)) <= 2;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.

    
        int ans = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {

                    boolean x = f(i, a) && f(j, b) && f(k, c);
                    boolean y = f(i, a2) && f(j, b2) && f(k, c2);

                    if (x || y) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.

        int cnt = 0;
        int draw = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1 && b[i] == 3) {
                cnt++;
            } else if (a[i] == 2 && b[i] == 1) {
                cnt++;
            } else if (a[i] == 3 && b[i] == 2) {
                cnt++;
            } else if (a[i] == b[i]) {
                draw++;
            }
        }

        System.out.println(Math.max(cnt, n-cnt-draw));
    }
}
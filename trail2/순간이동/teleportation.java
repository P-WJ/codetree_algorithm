import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int result = Math.abs(A-B);

        int t1 = Math.abs(A-x) + Math.abs(y-B);
        int t2 = Math.abs(A-y) + Math.abs(x-B);

        int t = Math.min(t1, t2);

        result = Math.min(result, t);

        System.out.println(result);
    }
}
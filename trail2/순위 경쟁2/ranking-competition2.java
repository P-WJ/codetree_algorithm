import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            arr[i] = c;

            int s = sc.nextInt();
            scores[i] = s;
        }
        // Please write your code here.

        int ans = 0;
        int a_score = 0;
        int b_score = 0;

        int flag = 0;
        for (int i = 0; i < n; i++) {
            int f = 0;

            if (arr[i] == 'A') {
                a_score += scores[i];
            } else {
                b_score += scores[i];
            }

            if (a_score == b_score) f = 0;
            else if (a_score > b_score) f = 1;
            else if (a_score < b_score) f = 2;
            
            if (flag != f) {
                ans++;
                flag = f;
            }
        }

        System.out.println(ans);
    }
}
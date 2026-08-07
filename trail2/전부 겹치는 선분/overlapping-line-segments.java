import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] arr = new int[101];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j <= end; j++) {
                arr[j] += 1;
            }
        }

        String ans = "No";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n) {
                ans = "Yes";
                break;
            }
        }
        System.out.println(ans);
    }
}
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;

    static boolean check(int limit) {
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + arr[i] <= limit) {
                sum += arr[i];
            } else {
                cnt++;
                sum = arr[i];
            }
        }

        return cnt <= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
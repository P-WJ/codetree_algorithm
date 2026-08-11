import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int min = arr[0];

        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
        }

        int secondNum = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (arr[i] > min) {
                secondNum = Math.min(secondNum, arr[i]);
            }
        }

        if (secondNum == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        int idx = -1;

        for (int i = 0; i < N; i++) {
            if (arr[i] == secondNum) {
                cnt++;
                idx = i;
            }
        }

        if (cnt == 1) {
            System.out.println(idx + 1);
        } else {
            System.out.println(-1);
        }
    }
}

import java.util.Scanner;

public class Main {
    
    static int k, n;
    static int[] arr;

    static void f(int cnt) {
        // N개의 숫자를 모두 선택했다면 출력
        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 현재 자리에 1~k 넣기
        for (int i = 1; i <= k; i++) {
            arr[cnt] = i;
            f(cnt + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        // Please write your code here.

        arr = new int[n];

        f(0);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] bomb = new int[n];

        for (int i = 0; i < n; i++) {
            bomb[i] = sc.nextInt();
        }

        int answer = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {

            boolean explode = false;

            // 거리 K 안에 같은 번호가 있는지 확인
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (bomb[i] == bomb[j] && Math.abs(i - j) <= k) {
                    explode = true;
                    break;
                }
            }

            if (!explode) continue;

            // 같은 번호 전체 개수 세기
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (bomb[j] == bomb[i]) {
                    cnt++;
                }
            }

            if (cnt > max) {
                max = cnt;
                answer = bomb[i];
            } else if (cnt == max && bomb[i] > answer) {
                answer = bomb[i];
            }
        }

        System.out.println(answer);
    }
}
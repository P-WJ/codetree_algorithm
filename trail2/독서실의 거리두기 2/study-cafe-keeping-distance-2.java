import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.


        int ans = 0;

        int existMinD = Integer.MAX_VALUE;
        // 기존 자리 거리 최소
        for (int i = 0; i < n-1; i++) {
                        
            for (int j = i+1; j < n; j++) {
                if (i == j) continue;
                if (seats.charAt(i) == '1' && seats.charAt(j) == '1') {
                    int d = Math.abs(i - j);
                    existMinD = Math.min(existMinD, d);
                }
            }
        }

        // 새 자리 거리 최소
        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '0') {
                int newMinD = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        int d = Math.abs(i - j);
                        newMinD = Math.min(newMinD, d);
                    }
                }

                // 기존, 새 자리 거리 최소
                int minD = Math.min(existMinD, newMinD);
                ans = Math.max(ans, minD);
            }     
        }
        System.out.println(ans);
    }
}
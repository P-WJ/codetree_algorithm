import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.

        int ans = 0;

        int existMinD = Integer.MAX_VALUE;
        // 기존 자리 최소거리
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (seats.charAt(i) == '1' && seats.charAt(j) == '1') {
                    int d = j-i;
                    existMinD = Math.min(existMinD, d);
                }
            }    
        }

        // 새 자리 최소 거리
        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '0') {
    
                int newMinD = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        
                        int d = Math.abs(i-j);
                        newMinD = Math.min(newMinD, d);

                    }
                }
                // 기존 자리와 새 자리의 최소거리 비교
                int minD = Math.min(existMinD, newMinD);

                // 가까운 두 사람 간 거리 중 최대
                ans = Math.max(ans, minD);
            }
        }

        System.out.println(ans);
    }
}
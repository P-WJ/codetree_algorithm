import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.

        int maxDist = 0;
        int maxI = 0; int maxJ = 0;

        for (int i = 0; i <n; i++) {
            if (seats.charAt(i) == '1') {
                for(int j = i+1; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        if (j - i > maxDist) {
                            maxDist = j - i;
                            maxI = i;
                            maxJ = j;
                        }

                        break;
                    }
                }
            }
        }

        int maxDist2 = -1;
        int maxIdx = -1;

        if (seats.charAt(0) == '0') {
            int dist = 0;
            for(int i = 0; i < n; i++) {
                if (seats.charAt(i) == '1') {
                    break;
                }
                dist++;
            }

            if (dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = 0;
            }
        }

        if (seats.charAt(n-1) == '0') {
            int dist = 0;
            for (int i = n-1; i > 0; i--) {
                if (seats.charAt(i) == '1') {
                    break;
                }
                dist++;
            }

            if (dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = n-1;
            }
        }

        if (maxDist2 >= maxDist / 2) {
            seats = seats.substring(0, maxIdx) + '1' + seats.substring(maxIdx + 1);
        } else {
            seats = seats.substring(0, (maxI + maxJ) / 2) + '1' + seats.substring((maxI + maxJ) / 2 + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '1') {
                for (int j = i+1; j < n; j++) {
                    if (seats.charAt(j) == '1') {
                        ans = Math.min(ans, j-i);
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
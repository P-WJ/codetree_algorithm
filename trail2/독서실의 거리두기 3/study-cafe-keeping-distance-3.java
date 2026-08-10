import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.

        int maxD = 0;
        int minD = Integer.MAX_VALUE;

        for (int  i = 0; i < N-1; i++) {

            for (int j = i+1; j < N; j++) {

                if (seats.charAt(i) == '1' && seats.charAt(j) == '1') {
                    int d = j - i;

                    minD = Math.min(minD, d);

                    maxD = Math.max(maxD, d / 2);

                    break;
                }
            }
        }

        System.out.println(Math.min(maxD, minD));
    }
}
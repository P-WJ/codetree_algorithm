import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.


        int ans = Integer.MAX_VALUE;

        for (int low = 0; low < 83; low++) {

            int high = low + 17;
            int cost = 0;

            for (int h : arr) {
                
                if (h < low) {
                    cost += (low - h) * (low - h);
                } else if (h > high) {
                    cost += (h - high) * (h - high);
                }
            }

            ans = Math.min(ans, cost);
        }

        System.out.println(ans);
        
    
    }
}
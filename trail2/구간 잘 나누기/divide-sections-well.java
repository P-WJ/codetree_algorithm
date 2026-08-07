import java.util.Scanner;
public class Main {
    
    static int n, m;
    static int nums[];

    static boolean check(int limit) {

        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + nums[i] <= limit) {
                sum += nums[i];
            } else {
                sum = nums[i];
                cnt++;
            }
        }

        return cnt <= m;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        // Please write your code here.


        int left = 0;
        int right = 0;
        
        for (int i = 0; i < n; i++) {
            left = Math.max(nums[i], left);
            right += nums[i];    
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
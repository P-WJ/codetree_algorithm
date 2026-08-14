import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        Deque<Integer> dq = new ArrayDeque<>();

        int n = sc.nextInt();
        
        for (int i = 1; i < n+1; i++) {
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.peekFirst());
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

         Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("push_front")) {
                int x = sc.nextInt();
                deque.addFirst(x);

            } else if (command.equals("push_back")) {
                int x = sc.nextInt();
                deque.addLast(x);

            } else if (command.equals("pop_front")) {
                System.out.println(deque.removeFirst());

            } else if (command.equals("pop_back")) {
                System.out.println(deque.removeLast());

            } else if (command.equals("size")) {
                System.out.println(deque.size());

            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("front")) {
                System.out.println(deque.peekFirst());

            } else if (command.equals("back")) {
                System.out.println(deque.peekLast());
            }
        }
    }
}
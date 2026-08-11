import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> l = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if (str.equals("push_front")) {
                int num = sc.nextInt();
                l.addFirst(num);

            } else if (str.equals("push_back")) {
                int num = sc.nextInt();
                l.addLast(num);

            } else if (str.equals("pop_front")) {
                System.out.println(l.pollFirst());

            } else if (str.equals("pop_back")) {
                System.out.println(l.pollLast());

            } else if (str.equals("size")) {
                System.out.println(l.size());

            } else if (str.equals("empty")) {
                if (l.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.equals("front")) {
                System.out.println(l.peekFirst());

            } else if (str.equals("back")) {
                System.out.println(l.peekLast());

            }
        }

    }
}
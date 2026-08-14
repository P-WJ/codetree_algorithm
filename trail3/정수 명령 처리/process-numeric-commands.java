import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Stack<Integer> stack = new Stack<>();
    
        for (int i = 0; i < n; i++) {

            String cmd = sc.next();
            
            if (cmd.equals("push")) {
                int k = sc.nextInt();
                stack.push(k);
            }

            else if (cmd.equals("size")) {
                System.out.println(stack.size());
            }

            else if (cmd.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            else if (cmd.equals("pop")) {
                System.out.println(stack.pop());
            }

            else if (cmd.equals("top")) {
                System.out.println(stack.peek());
            }
        }
    }
}
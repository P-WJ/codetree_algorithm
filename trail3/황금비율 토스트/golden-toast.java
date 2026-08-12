import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Character> l = new LinkedList<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            l.add(s.charAt(i));
        }

        ListIterator<Character> it = l.listIterator(l.size());


        for (int i = 0; i < m; i++) {
            String command = sc.next();

            if (command.equals("L")) {
                if (it.hasPrevious()) {
                    it.previous();
                }
            }

            else if (command.equals("R")) {
                if (it.hasNext()) {
                    it.next();
                }
            }

            else if (command.equals("D")) {
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }

            else if (command.equals("P")) {
                String c = sc.next();
                it.add(c.charAt(0));
            }            
        }
        
        for (char c : l) {
            System.out.print(c);
        }
        
    }
}

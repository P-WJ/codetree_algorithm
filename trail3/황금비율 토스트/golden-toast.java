import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Character> l = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        
        for (int i = 0; i < n; i++) {
            l.add(s.charAt(i));
        }

        ListIterator<Character> it = l.listIterator(l.size());


        for (int i = 0; i < m; i++) {
            String command = br.readLine();

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

            else if (command.charAt(0) == 'P') {
                it.add(command.charAt(2));
            }            
        }
        
        for (char c : l) {
            System.out.print(c);
        }
        
    }
}
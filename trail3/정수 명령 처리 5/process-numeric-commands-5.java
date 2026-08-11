import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            

            if (str.equals("push_back")) {
                int num = sc.nextInt();
                arr.add(num);
            } else if (str.equals("pop_back")) {
                arr.remove(arr.size()-1);
            } else if (str.equals("size")) {
                System.out.println(arr.size());
            } else if (str.equals("get")) {
                int num = sc.nextInt();
                System.out.println(arr.get(num-1));
            }
        }
    }
}
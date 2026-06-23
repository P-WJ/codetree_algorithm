import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> abil = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            abil.add(sc.nextInt());
        }
        // Please write your code here.

        Collections.sort(abil);
        
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            arr.add(abil.get(i) + abil.get(abil.size()-1-i));
        }

        int ans = Collections.max(arr) - Collections.min(arr);

        System.out.println(ans);
    }
}
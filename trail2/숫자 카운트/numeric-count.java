import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        // Please write your code here.

        int ans = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {

                if (i == j) {
                    continue;
                }

                for (int k = 1; k < 10; k++) {

                    if (i == k || j == k) {
                        continue;
                    }

                    String t = "" + i + j + k;
                    boolean f = true;

                    for (int x = 0; x < n; x++) {
                        int c1 = 0;
                        int c2 = 0;

                        String g = "" + num[x];

                        for (int y = 0; y < 3; y++) {
                            
                            if (g.charAt(y) == t.charAt(y)) {
                                c1++;
                            }
                            else if (t.contains(String.valueOf(g.charAt(y)))) {
                                c2++;
                            }
                        }

                        if (count1[x] != c1 || count2[x] != c2) {
                            f = false;
                            break;
                        }
                    }
                    
                    if (f) {
                        ans++;
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
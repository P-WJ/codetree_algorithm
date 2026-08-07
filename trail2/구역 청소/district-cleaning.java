import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        int[] arr = {a, b, c, d};

        if (b < c || a > d) {
            System.out.println(b-a + d-c);
        } else {
            int maxVal = 0;
            int minVal = 100;
            for (int i = 0; i < 4; i++) {
                if (maxVal < arr[i]) maxVal = arr[i];
                if (minVal > arr[i]) minVal = arr[i];
            }
            System.out.println(maxVal - minVal);
        }
    }
}
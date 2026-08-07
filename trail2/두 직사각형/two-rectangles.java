import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        
        // Please write your code here.
        if (x2 < a1 || x1 > a2 || y2 < b1 || y1 > b2) {
                System.out.println("nonoverlapping");
            } else {
                System.out.println("overlapping");
            }
    }
}
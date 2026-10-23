import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
            matrix[i][i] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (matrix[k][j] == 0) continue;
                    matrix[i][j] = 1;       
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
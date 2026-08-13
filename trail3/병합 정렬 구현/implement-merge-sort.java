import java.util.Scanner;

public class Main {
    
    static int n;
    static int[] arr;
    static int[] tmp;

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[k] = arr[i];
                k++;
                i++;
            } else {
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            tmp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= high) {
            tmp[k] = arr[j];
            k++;
            j++;
        }

        for (int l = low; l <= high; l++) {
            arr[l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Please write your code here.

        mergeSort(arr, 0, n-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
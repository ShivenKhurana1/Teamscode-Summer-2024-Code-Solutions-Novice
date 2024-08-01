import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        int[] pre = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            pre[i + 1] = pre[i] ^ (arr[i] + arr[i]);
        }
        
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(pre[l - 1] ^ pre[r]);
        }
        
        scanner.close();
    }
}


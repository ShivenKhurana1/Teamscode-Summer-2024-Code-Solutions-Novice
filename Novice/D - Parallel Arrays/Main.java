import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int MOD = (int) (1e9 + 7);
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vis = new int[3 * n];
        int l = 1;

        List<int[]> prs = new ArrayList<>();
        for (int q = 0; q < n; q++) {
            int t = scanner.nextInt();
            int v = scanner.nextInt();
            int r = (t == 1) ? (v - l) : (t == 2) ? (l + v) : v;
            prs.add(new int[]{l, r});
            vis[l] = 1;
            vis[r] = 1;
            while (vis[l] == 1) l++;
        }

        int res = 2;
        for (int i = 0; i < prs.size() - 1; i++) {
            int[] p1 = prs.get(i);
            int[] p2 = prs.get(i + 1);
            if (Math.min(p2[0], p2[1]) > Math.max(p1[0], p1[1])) {
                res = (res * 2) % MOD;
            }
        }

        System.out.println(res);
        scanner.close();
    }
}


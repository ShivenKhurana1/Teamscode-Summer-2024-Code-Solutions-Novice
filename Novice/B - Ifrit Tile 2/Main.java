import java.util.Scanner;

public class Main {
    static final int MX = 1000 + 10;
    static int n, m;
    static char[][] grid = new char[MX][MX];

    static boolean check(int x, int y, int dx, int dy) {
        if (grid[x][y] != 'H') return false;
        int ans = 0;
        for (int i = 1; i < 6; i++) {
            x += dx;
            y += dy;
            if (x < 0 || y < 0 || x >= n || y >= m) break;
            ans += (grid[x][y] == 'L') ? 1 : 0;
        }
        return ans >= 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean work = false;
                for (int dx : new int[]{-1, 0, 1}) {
                    for (int dy : new int[]{-1, 0, 1}) {
                        if (Math.abs(dx) + Math.abs(dy) != 1) continue;
                        work |= check(i, j, dx, dy);
                    }
                }
                ans += work ? 1 : 0;
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}


import java.util.*;

public class Main {
    static int n;
    static int m;
    static int h;

    static boolean finish = false;
    static int[][] ladder;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        ladder = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladder[a][b] = 1;
        }

        solve();

    }

    public static void solve() {
        int limit = 3;

        for (int i = 0; i <= limit; i++) {
            dfs(0, i);
            if (finish)
                return;
        }

        System.out.println(-1);

    }

    public static void dfs(int count, int limit) {
        if (count == limit) {
            if (check()) {
                System.out.println(limit);
                finish = true;
            }
            return;
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                // 이미 선이 그어져있다면, 건너뛰기
                if (ladder[i][j] == 1)
                    continue;

                // 왼쪽 선이 그어져있다면 건너뛰기
                if (ladder[i][j - 1] == 1)
                    continue;

                // 오른쪽 선이 그어져있다면 건너뛰기
                if (ladder[i][j + 1] == 1)
                    continue;

                ladder[i][j] = 1;
                dfs(count + 1, limit);
                if (finish)
                    return;
                ladder[i][j] = 0;
            }
        }

    }

    public static boolean check() {
        for (int i = 1; i <= n; i++) {
            int pos = i;
            for (int row = 1; row <= h; row++) {
                if (ladder[row][pos] == 1) {
                    pos++;
                } else if (ladder[row][pos - 1] == 1) {
                    pos--;
                }
            }
            if (i != pos) {
                return false;
            }
        }
        return true;
    }

}
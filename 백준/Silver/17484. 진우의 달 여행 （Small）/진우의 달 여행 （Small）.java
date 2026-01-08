import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    static int[] dy = { -1, 0, 1 };
    // x는 무조건 -1이라 생략한다.
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve();
        sc.close();
    }

    public static void solve() {
        for (int i = 0; i < m; i++) {
            dfs(0, i, -1, map[0][i]); // (0,0) (1,0) (2,0) 부터 시작
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, int arrow, int sum) {
        if (x == n - 1) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {

            if (arrow == i)
                continue;

            int nx = x + 1;
            int ny = y + dy[i];

            if (nx < 0 || n <= nx)
                continue;
            if (ny < 0 || m <= ny)
                continue;
            dfs(nx, ny, i, sum + map[nx][ny]);
        }
    }

}
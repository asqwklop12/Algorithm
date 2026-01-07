import java.io.*;
import java.util.*;

public class Main {

    static int r;
    static int c;
    static int k;
    static char map[][];
    static boolean visit[][];

    static int count = 0;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        map = new char[r][c];
        visit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        map[0][c - 1] = 'H';
        solve();
        sc.close();
    }

    public static void solve() {
        visit[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(count);

    }

    public static void dfs(int x, int y, int dist) {

        if (dist == k) {
            if (map[x][y] == 'H') {
                count++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || r <= nx)
                continue;
            if (ny < 0 || c <= ny)
                continue;

            if (map[nx][ny] == 'T')
                continue;
            if (visit[nx][ny])
                continue;

            visit[nx][ny] = true;
            dfs(nx, ny, dist + 1);
            visit[nx][ny] = false;
        }
    }

}

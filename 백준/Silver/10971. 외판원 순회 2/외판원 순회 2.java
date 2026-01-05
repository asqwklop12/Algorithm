import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve();
        sc.close();
    }

    public static void solve() {
        visited[0] = true;
        dfs(0, 1, 0);
        System.out.println(result);
    }

    public static void dfs(int cur, int count, int total) {

        if (count == n) {
            if (map[cur][0] != 0) {
                result = Math.min(result, total + map[cur][0]);
            }
            return;
        }

        for (int next = 0; next < n; next++) {
            if (visited[next] || map[cur][next] == 0)
                continue;
            visited[next] = true;
            dfs(next, count + 1, total + map[cur][next]);
            visited[next] = false;
        }
    }

}
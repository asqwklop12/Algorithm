import java.util.*;

public class Main {

    static int N, M;

    static int[][] map;
    static boolean[][] visited;
    static int ans = 0;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
            }
        }

        solve();
        System.out.println(ans);
    }

    public static void solve() {
        dfs(0, 0, 0);
    }

    public static void dfs(int x, int y, int sum) {
        if (x == N) {
            x = 0;
            y++;
        }

        if (y == M) { // 탐색 종료
            ans = Math.max(ans, sum);
            return;
        }

        dfs(x + 1, y, sum);

        if (!visited[x][y]) {
            // 1 x,y를기준으로 x y-1, x-1 y인 경우
            if (x - 1 >= 0 && y - 1 >= 0 && !visited[x - 1][y] && !visited[x][y - 1]) {
                visited[x][y] = true;
                visited[x - 1][y] = true;
                visited[x][y - 1] = true;
                dfs(x, y, sum + (map[x][y] * 2) + map[x - 1][y] + map[x][y - 1]);
                visited[x][y] = false;
                visited[x - 1][y] = false;
                visited[x][y - 1] = false;
            }
            // 2 x,y를기준으로 x y-1, x+1 y인 경우
            if (x + 1 < N && y - 1 >= 0 && !visited[x][y - 1] && !visited[x + 1][y]) {
                visited[x][y] = true;
                visited[x + 1][y] = true;
                visited[x][y - 1] = true;
                dfs(x, y, sum + (map[x][y] * 2) + map[x][y - 1] + map[x + 1][y]);
                visited[x][y] = false;
                visited[x + 1][y] = false;
                visited[x][y - 1] = false;
            }
            // 3 x,y를기준으로 x-1 y, x y+1인 경우
            if (x - 1 >= 0 && y + 1 < M && !visited[x - 1][y] && !visited[x][y + 1]) {
                visited[x][y] = true;
                visited[x - 1][y] = true;
                visited[x][y + 1] = true;
                dfs(x, y, sum + (map[x][y] * 2) + map[x - 1][y] + map[x][y + 1]);
                visited[x][y] = false;
                visited[x - 1][y] = false;
                visited[x][y + 1] = false;

            }
            // 4 x,y를기준으로 x+1 y, x y+1인 경우
            if (x + 1 < N && y + 1 < M && !visited[x + 1][y] && !visited[x][y + 1]) {
                visited[x][y] = true;
                visited[x + 1][y] = true;
                visited[x][y + 1] = true;
                dfs(x, y, sum + (map[x][y] * 2) + map[x + 1][y] + map[x][y + 1]);
                visited[x][y] = false;
                visited[x + 1][y] = false;
                visited[x][y + 1] = false;

            }

        }

    }

}

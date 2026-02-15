import java.util.*;

public class Main {
    static int l;
    static int m;
    static char[][] map;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        m = sc.nextInt();
        map = new char[l][m];

        for (int i = 0; i < l; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        solve();

    }

    public static void solve() {
        int answer = -1;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        int[][] dist = new int[l][m];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { x, y });
        dist[x][y] = 0;
        int max = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || l <= nx)
                    continue;
                if (ny < 0 || m <= ny)
                    continue;
                if (map[nx][ny] == 'W')
                    continue;

                if (dist[nx][ny] != -1)
                    continue;

                dist[nx][ny] = dist[cx][cy] + 1;
                max = Math.max(max, dist[nx][ny]);
                q.add(new int[] { nx, ny });
            }
        }
        return max;
    }

}

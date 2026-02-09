import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] dist; // 각 칸의 안전거리 저장
    static int max = Integer.MIN_VALUE;
    static int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
    static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    dist[i][j] = 0; // 상어 위치는 거리 0
                } else {
                    dist[i][j] = -1; // 방문 안함 표시
                }
            }
        }

        bfs(q);

        // 최댓값 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != -1) {
                    max = Math.max(max, dist[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                // 이미 방문했거나(거리가 계산됨) 상어인 경우 패스
                if (dist[nx][ny] != -1)
                    continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[] { nx, ny });
            }
        }
    }

}

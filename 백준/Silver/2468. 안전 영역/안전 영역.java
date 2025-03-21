import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {1, -1, 0, 0};  // 상하좌우 이동 (대각선 제거)
    static int[] dy = {0, 0, 1, -1};
    static int[][] map; // 입력받을 맵
    static int n; // 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 크기 입력
        map = new int[n][n];

        int mx = -1;
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
                mx = Math.max(mx, map[i][j]);
            }
        }


        int maxArea = 0;
        for (int count = 0; count <= mx; count++) {
            int area = 0;  // 영역 개수
            boolean[][] visited = new boolean[n][n]; // 방문 체크 배열
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // `count`보다 큰 영역만 탐색 (기존 코드에서 오류 수정)
                    if (map[i][j] > count && !visited[i][j]) {
                        bfs(i, j, visited, count);
                        area++; // BFS를 실행한 경우만 영역 증가
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }

    private static void bfs(int x, int y, boolean[][] visited, int count) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point c = q.poll();
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                // 범위를 벗어나면 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                // 방문했거나 `count` 이하이면 무시
                if (visited[nx][ny] || map[nx][ny] <= count) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
}

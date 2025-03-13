import java.io.*;
import java.util.*;
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Queue<Point> q = new LinkedList<>();
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] dimensions = br.readLine().split(" ");
        n = Integer.parseInt(dimensions[0]);
        k = Integer.parseInt(dimensions[1]);

        // map과 visited 배열의 크기를 입력 크기에 맞게 할당
        map = new int[n+10][k+10];
        visited = new boolean[n+10][k+10];

        // 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String[] enter = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                map[i][j] = Integer.parseInt(enter[j]);
            }
        }

        int count = 0;
        int mx = 0;

        // 각 셀을 탐색하며 연결된 영역의 크기를 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    mx = Math.max(bfs(), mx);
                    count++;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
        System.out.println(mx);
    }

    static public int bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int area = 1;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 제한
                if (nx < 0 || nx >= n || ny < 0 || ny >= k) continue;

                // 이미 방문했거나, 0인 곳은 넘어간다.
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                // 이동 후 방문 처리
                area++;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }

        return area;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    static char[][] map; // 입력받을 맵
    static int n; // 크기
    static int m; // 크기

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 크기 입력
        m = Integer.parseInt(st.nextToken()); // 크기 입력
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문하지 않는곳만 방문
                if (!visited[i][j]) {
                    dfs(new Point(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(Point point) {
        int x = point.x;
        int y = point.y;
        // 방문 표시를 하구
        visited[x][y] = true;

        char now = map[x][y];

        if (now == '-') {
            if (y + 1 < m && map[x][y + 1] == '-' && !visited[x][y + 1]) {
                dfs(new Point(x, y + 1));

            }
        }


        if (now == '|') {
            if (x + 1 < n && map[x + 1][y] == '|' && !visited[x + 1][y]) {
                dfs(new Point(x + 1, y));
            }
        }

    }


}

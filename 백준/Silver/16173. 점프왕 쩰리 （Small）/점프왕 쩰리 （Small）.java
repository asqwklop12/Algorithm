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

    static int[] dx = {1, 0};  // 상하좌우 이동 (대각선 제거)
    static int[] dy = {0, 1};
    static int[][] map; // 입력받을 맵
    static int n; // 크기

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 크기 입력

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(new Point(0, 0));

        System.out.println("Hing");

    }

    private static void dfs(Point point) {
        int x = point.x;
        int y = point.y;
        if (map[x][y] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int k = 0; k < 2; k++) {
            int nx = x + dx[k] * map[x][y];
            int ny = y + dy[k] * map[x][y];
            if (nx >= n || ny >= n || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(new Point(nx, ny));
        }

    }


}

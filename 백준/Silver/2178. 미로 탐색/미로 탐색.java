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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int k = Integer.parseInt(dimensions[1]);

        int[][] map = new int[100][100];
        int[][] graph = new int[n][k];
        boolean[][] visited = new boolean[100][100];
        Queue<Point> q = new LinkedList<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        q.add(new Point(0, 0));
        visited[0][0] = true;
        graph[0][0] = 1;


        for (int i = 0; i < n; i++) {
            String nS = br.readLine();
            for (int j = 0; j < k; j++) {
                map[i][j] = nS.charAt(j) - '0';
            }
        }

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                // 범위 제한
                if (nx < 0 || n <= nx) continue;
                if (ny < 0 || k <= ny) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                // 이동
                graph[nx][ny] = graph[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));

            }

        }

        System.out.println(graph[n - 1][k - 1]);
    }
}
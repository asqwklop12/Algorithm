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

    static int[][] maps; // 입력받을 맵
    static int n; // 크기

    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 크기 입력
        int m = Integer.parseInt(br.readLine()); // 크기 입력

        maps = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            maps[x][y] = 1;
            maps[y][x] = 1;
        }

        dfs(1);
        System.out.println(count - 1);


    }

    private static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int i = 0; i <= n; i++) {
            if (maps[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }


}

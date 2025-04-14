import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[][] maps = new int[1000][1000];
  static int[][] visited = new int[1000][1000];
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String st = br.readLine();
      for (int j = 0; j < N; j++) {
        maps[i][j] = st.charAt(j) - '0';
      }
    }

    for (int i = 0; i < N; i++) {
      Arrays.fill(visited[i], -1);
    }

    int count = 0;
    List<Integer> counts = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (maps[i][j] == 1 && visited[i][j] == -1) {
          visited[i][j] = 1;
          counts.add(dfs(new Point(i, j)));
          count++;
        }
      }
    }
    Collections.sort(counts);

    System.out.println(count);

    for (Integer c : counts) {
      System.out.println(c);
    }
  }

  private static int dfs(Point point) {
    int x = point.x;
    int y = point.y;
    int count = 1;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 범위 제한
      if (nx < 0 || N <= nx || ny < 0 || N <= ny) {
        continue;
      }

      // 이동하는 곳이 0이 아니다.
      if (maps[nx][ny] == 0) {
        continue;
      }
      // 이동

      if (visited[nx][ny] != -1) {
        continue;
      }
      visited[nx][ny] = visited[x][y] + 1;
      count += dfs(new Point(nx, ny));
    }
    return count;
  }


}

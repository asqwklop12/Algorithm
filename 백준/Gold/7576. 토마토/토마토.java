import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[m][n];
        int[][] move = new int[m][n];

        Queue<Point> tomato = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    tomato.add(new Point(i, j));
                }
                if (map[i][j] == 0) {
                    move[i][j] = -1;
                }
            }
        }

        while (!tomato.isEmpty()) {
            var point = tomato.poll();
            int cx = point.x;
            int cy = point.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= m) continue;
                if (ny < 0 || ny >= n) continue;
                if (move[nx][ny] >= 0) continue;
                move[nx][ny] = move[cx][cy] + 1;
                tomato.add(new Point(nx, ny));
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(move[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
//                System.out.print(move[i][j] + " ");
                ans = Math.max(ans, move[i][j]);
            }
//            System.out.println();
        }
        System.out.println(ans);
    }
}

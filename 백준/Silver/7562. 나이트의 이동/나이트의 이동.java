import java.io.*;
import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

    // 방문

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 방문
            int[][] visits = new int[l][l];
            // -1로 초기화를 시켜준다.
            for (int[] visit : visits) {
                Arrays.fill(visit, -1);
            }

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            StringTokenizer et = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(et.nextToken());
            int ey = Integer.parseInt(et.nextToken());
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(sx, sy));
            visits[sx][sy] = 0;
            while (!q.isEmpty()) {
                Point c = q.poll();
                for (int i = 0; i < 8; i++) {
                    int mx = dx[i] + c.x;
                    int my = dy[i] + c.y;
                    if (0 > mx || l <= mx) continue;
                    if (0 > my || l <= my) continue;
                    if (visits[mx][my] != -1) continue;
                    visits[mx][my] = visits[c.x][c.y] + 1;
                    q.add(new Point(mx, my));
                }

            }

            System.out.println(visits[ex][ey]);


        }
    }

}
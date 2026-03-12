import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastReader fr = new FastReader();
        int k = Integer.parseInt(fr.next());
        int w = Integer.parseInt(fr.next());
        int h = Integer.parseInt(fr.next());
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(fr.next());
            }
        }
        System.out.println(this.solve(k, w, h, grid));
    }

    int k;
    int w;
    int h;
    int[][] grid;

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    int[] hx = { 1, 2, -1, -2, 1, 2, -1, -2 };
    int[] hy = { 2, -1, -2, -1, -2, 1, 2, 1 };

    int[][][] dist;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int k, int w, int h, int[][] grid) {
        this.k = k;
        this.w = w;
        this.h = h;
        this.grid = grid;
        this.dist = new int[k + 1][w][h];

        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        return bfs(0, 0);
    }

    public int bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { k, sx, sy });
        dist[k][sx][sy] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curK = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == w - 1 && y == h - 1)
                return dist[curK][x][y];

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                int nk = curK;

                if (nx < 0 || w <= nx)
                    continue;
                if (ny < 0 || h <= ny)
                    continue;

                if (grid[ny][nx] == 1) {
                    continue;
                }

                if (dist[nk][nx][ny] != -1)
                    continue;

                dist[nk][nx][ny] = dist[curK][x][y] + 1;
                q.add(new int[] { nk, nx, ny });
            }

            if (curK > 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = hx[d] + x;
                    int ny = hy[d] + y;
                    int nk = curK - 1;

                    if (nx < 0 || w <= nx)
                        continue;
                    if (ny < 0 || h <= ny)
                        continue;

                    if (dist[nk][nx][ny] != -1)
                        continue;

                    if (grid[ny][nx] == 1) {
                        continue;
                    }
                    dist[nk][nx][ny] = dist[curK][x][y] + 1;

                    if (grid[ny][nx] == 1) {
                        return dist[nk][nx][ny];
                    }

                    q.add(new int[] { nk, nx, ny });
                }

            }

        }

        return -1;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public boolean hasMoreTokens() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                if (line == null)
                    return false;
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}

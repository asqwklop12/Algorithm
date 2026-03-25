import java.io.*;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
        int T = Integer.parseInt(fr.next());
        while(T-- > 0) {
            int n = Integer.parseInt(fr.next());
            int[][] grid = new int[2][2];
            for(int i=0; i<2; i++) for(int j=0; j<2; j++) grid[i][j] = Integer.parseInt(fr.next());
            System.out.println(this.solve(n, grid));
        }
    }
    int[] dx = { 2, 2, 1, -1, -2, -2, 1, -1 };
    int[] dy = { 1, -1, 2, 2, 1, -1, -2, -2 };

    int n;
    int endX, endY;
    boolean[][] visited;

    public int solve(int n, int[][] grid) {
        visited = new boolean[n][n];
        this.n = n;

        int startX = grid[0][0];
        int startY = grid[0][1];

        this.endX = grid[1][0];
        this.endY = grid[1][1];

        return bfs(startX, startY);
    }

    public int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { x, y, 0 });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (cx == endX && cy == endY) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || n <= nx)
                    continue;

                if (ny < 0 || n <= ny) {
                    continue;
                }

                if (visited[nx][ny])
                    continue;

                visited[nx][ny] = true;

                q.add(new int[] { nx, ny, dist + 1 });

            }
        }

        return -1;
    }

    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { } } return st.nextToken(); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public boolean hasMoreTokens() { while (st == null || !st.hasMoreElements()) { String line = null; try { line = br.readLine(); } catch (IOException e) { } if (line == null) return false; st = new StringTokenizer(line); } return true; }
    }
}

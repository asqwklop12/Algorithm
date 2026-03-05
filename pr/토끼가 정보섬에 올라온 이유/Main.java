import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        char[][] grid = new char[n][];
        for(int i=0; i<n; i++) grid[i] = fr.next().toCharArray();
        this.n = n;
        this.m = m;
        this.grid = grid;
        System.out.println(this.solve(n, m, grid));
    }
    public int n;
    public int m;
    public char[][] grid;

    public int[] dx = { -1, 0, 1 };
    public int[] dy = { 1, 1, 1 };

    public int[][] memo;

    /**
     * 문제 해결 메서드
     * 
     * @param n    행의 수
     * @param m    열의 수
     * @param grid 격자 데이터
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int m, char[][] grid) {
        this.n = n;
        this.m = m;
        this.grid = grid;
        this.memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int rx = -1;
        int ry = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }

        return dfs(rx, ry) <= -987654321 ? -1 : dfs(rx, ry);
    }

    public int dfs(int x, int y) {
        int res = -987654321;

        if (grid[x][y] == 'O') {
            res = 0;
        }
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        for (int i = 0; i < 3; i++) {
            int cc = 0;

            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || n <= nx)
                continue;
            if (ny < 0 || m <= ny)
                continue;
            if (grid[nx][ny] == '#') {
                continue;
            }

            if (grid[nx][ny] == 'C') {
                cc++;
            }

            int next = dfs(nx, ny);

            if (next != -987654321) {
                res = Math.max(res, cc + next);
            }
        }

        return memo[x][y] = res;

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

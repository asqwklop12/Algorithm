import java.io.*;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        int k = Integer.parseInt(fr.next());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
        String line = fr.next();
        for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
        }
        }
        System.out.println(this.solve(n, m, k, map));
    }
    public int n;
    public int m;
    public int k;
    public int[][] map;
    public int[] dx = { 0, 0, 1, -1 };
    public int[] dy = { 1, -1, 0, 0 };

    public boolean[][][] visited;

    /**
     * 문제 해결 메서드
     * 
     * @param n   행 개수
     * @param m   열 개수
     * @param k   부술 수 있는 벽의 개수
     * @param map 지도 데이터 (0: 빈 칸, 1: 벽)
     * @return 최단 경로 (불가능하면 -1)
     */
    public int solve(int n, int m, int k, int[][] map) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.map = map;
        this.visited = new boolean[n + 1][m + 1][k + 1];

        return bfs(0, 0);
    }

    public int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y, k, 1 });
        visited[x][y][k] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ck = cur[2];
            int dist = cur[3];

            if (cx == n - 1 && cy == m - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nk = ck;

                if (nx < 0 || n <= nx)
                    continue;
                if (ny < 0 || m <= ny)
                    continue;

                if (visited[nx][ny][nk])
                    continue;

                // 벽인 경우
                if (map[nx][ny] == 0) {
                    if (visited[nx][ny][ck]) {
                        continue;
                    }
                } else {
                    if (ck == 0 || visited[nx][ny][ck - 1]) {
                        continue;
                    }
                    nk--;

                }

                visited[nx][ny][nk] = true;
                q.offer(new int[] { nx, ny, nk, dist + 1 });
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

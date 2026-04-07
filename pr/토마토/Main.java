import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int m = Integer.parseInt(fr.next());
        int n = Integer.parseInt(fr.next());
        int h = Integer.parseInt(fr.next());
        int[][][] grid = new int[h][n][m];
        for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
        grid[k][i][j] = Integer.parseInt(fr.next());
        }
        }
        }
        System.out.println(this.solve(m, n, h, grid));
    }
    int[] dh = { 0, 0, 0, 0, 1, -1 };
    int[] dx = { 1, -1, 0, 0, 0, 0 };
    int[] dy = { 0, 0, 1, -1, 0, 0 };

    int n;
    int m;
    int h;
    int[][][] grid;
    int[][][] dist;

    int minDay = Integer.MAX_VALUE;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int m, int n, int h, int[][][] grid) {
        this.m = m;
        this.n = n;
        this.h = h;
        this.grid = grid;
        this.dist = new int[h][n][m];

        return bfs();
    }

    public int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int unripenCount = 0;

        // BFS 시작 전, 모든 익은 토마토를 찾아 큐에 저장 (시작점)
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dist[i][j][k] = -1;
                    if (grid[i][j][k] == 1) {
                        q.add(new int[] { k, j, i });
                        dist[i][j][k] = 0;
                    } else if (grid[i][j][k] == 0) {
                        unripenCount++;
                    }
                }
            }
        }

        // 이미 모든 토마토가 다 익어 있다면 0일
        if (unripenCount == 0) {
            return 0;
        }

        int maxDay = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0]; // x
            int cy = cur[1]; // y
            int ch = cur[2]; // h

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nh = ch + dh[i];

                if (nx < 0 || m <= nx)
                    continue;
                if (ny < 0 || n <= ny)
                    continue;
                if (nh < 0 || h <= nh)
                    continue;

                // 안 익은 공간(0)만 방문
                if (grid[nh][ny][nx] != 0) {
                    continue;
                }

                if (dist[nh][ny][nx] != -1) {
                    continue;
                }

                dist[nh][ny][nx] = dist[ch][cy][cx] + 1;
                maxDay = Math.max(maxDay, dist[nh][ny][nx]);
                unripenCount--;
                q.add(new int[] { nx, ny, nh });
            }
        }

        // 큐가 다 비었는데도 안 익은 토마토가 남아있다면 모두 익지 못한 상황
        if (unripenCount > 0) {
            return -1;
        }

        return maxDay;
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

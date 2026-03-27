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
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
        grid[i] = fr.next();
        }
        System.out.println(this.solve(n, m, grid));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param n    미로 세로 크기
     * @param m    미로 가로 크기
     * @param maze 미로 행 데이터 배열
     * @return 문제에 맞는 반환 타입
     */
    public char[][] grid;
    public int n;
    public int m;

    public int[] dx = { -1, 1, 0, 0 };
    public int[] dy = { 0, 0, -1, 1 };

    public int solve(int n, int m, String[] maze) {
        this.grid = new char[n][m];
        this.n = n;
        this.m = m;
        for (int i = 0; i < n; i++) {
            this.grid[i] = maze[i].toCharArray();
        }

        int sx = -1;
        int sy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }

        return bfs(sx, sy);
    }

    public int bfs(int sx, int sy) {

        int[][][] dist = new int[64][n][m];
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }

        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, sx, sy });
        dist[0][sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curKeys = cur[0];
            int x = cur[1];
            int y = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || n <= nx)
                    continue;
                if (ny < 0 || m <= ny)
                    continue;
                if (grid[nx][ny] == '#')
                    continue;

                int nextKeys = curKeys;

                // 문에 도착시 열쇠가 필요하다.
                // 존재하지 않는 경우 이동이 불가능하다.
                if (List.of('A', 'B', 'C', 'D', 'E', 'F').contains(grid[nx][ny])) {
                    int keyPower = (int) Math.pow(2, grid[nx][ny] - 'A');
                    if ((curKeys / keyPower) % 2 == 0)
                        continue;
                }

                // 열쇠에 도달했을 경우
                if (List.of('a', 'b', 'c', 'd', 'e', 'f').contains(grid[nx][ny])) {
                    int keyPower = (int) Math.pow(2, grid[nx][ny] - 'a');
                    if ((curKeys / keyPower) % 2 == 0) {
                        nextKeys = curKeys + keyPower;
                    }
                }

                if (dist[nextKeys][nx][ny] != -1)
                    continue;

                dist[nextKeys][nx][ny] = dist[curKeys][x][y] + 1;

                if (grid[nx][ny] == '1') {
                    return dist[nextKeys][nx][ny];
                }

                q.add(new int[] { nextKeys, nx, ny });

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

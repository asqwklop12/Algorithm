import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastReader fr = new FastReader();
        if (!fr.hasMoreTokens())
            return;
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = fr.nextInt();
            }
        }

        int[][] result = this.solve(n, m, grid);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public int n, m;
    public int[][] grid;

    // x, y 좌표를 각각 따로 메모하면 메모리도 아끼고 처리도 빠릅니다.
    public int[][] memoX;
    public int[][] memoY;

    public int[][] solve(int n, int m, int[][] grid) {
        this.n = n;
        this.m = m;
        this.grid = grid; // 필드 변수 할당 필수!
        int[][] result = new int[n][m];

        memoX = new int[n][m];
        memoY = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                memoX[i][j] = -1; // 초기화
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] dest = findDest(i, j);
                result[dest[0]][dest[1]]++;
            }
        }
        return result;
    }

    public int[] findDest(int x, int y) {
        // 1. 이미 아는 길이면 바로 리턴
        if (memoX[x][y] != -1) {
            return new int[] { memoX[x][y], memoY[x][y] };
        }

        int currX = x, currY = y;

        // 2. 재귀 대신 while문으로 종착지까지 달리기 (StackOverflow 방지)
        while (true) {
            int minX = currX, minY = currY;
            int minVal = grid[currX][currY];

            for (int i = 0; i < 8; i++) {
                int nx = currX + dx[i], ny = currY + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (grid[nx][ny] < minVal) {
                    minVal = grid[nx][ny];
                    minX = nx;
                    minY = ny;
                }
            }

            // 멈출 곳을 찾았다면?
            if (minX == currX && minY == currY)
                break;

            // 만약 다음 칸의 종착지를 이미 안다면? 바로 거기라고 메모하고 끝내기
            if (memoX[minX][minY] != -1) {
                currX = memoX[minX][minY];
                currY = memoY[minX][minY];
                break;
            }

            currX = minX;
            currY = minY;
        }

        // 3. 찾은 종착지를 메모지에 적어두기
        memoX[x][y] = currX;
        memoY[x][y] = currY;
        return new int[] { currX, currY };
    }

    public int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    public int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

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

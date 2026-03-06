import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
        if (!fr.hasMoreTokens()) return;
        int T = Integer.parseInt(fr.next());
        while (T-- > 0) {
            int r = Integer.parseInt(fr.next());
            int c = Integer.parseInt(fr.next());
            char[][] grid = new char[r][c];
            for (int i = 0; i < r; i++) {
                grid[i] = fr.next().toCharArray();
            }
            System.out.println(solve(r, c, grid));
        }
    }
    /**
     * 문제 해결 메서드
     * 
     * @param r    행의 수
     * @param c    열의 수
     * @param grid 사탕 박스 데이터 (2차원 문자 배열)
     * @return 발견된 사탕의 수
     */
    public int solve(int r, int c, char[][] grid) {
        int count = 0;

        // 46은 . 111 o 60 < 62 > 94 ^ 118 v
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 2; j++) {
                if (grid[i][j] == '>' && grid[i][j + 1] == 'o' && grid[i][j + 2] == '<') {
                    count++;
                }

            }
        }

        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'v' && grid[i + 1][j] == 'o' && grid[i + 2][j] == '^') {
                    count++;
                }

            }
        }

        return count;
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

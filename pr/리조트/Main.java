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
        int[] arr = new int[m];
        for(int i=0; i<m; i++) arr[i] = Integer.parseInt(fr.next());
        System.out.println(this.solve(n, m, arr));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */

    public int solve(int n, int m, int[] arr) {
        int oneDay = 10000;
        int threeDay = 25000;
        int fiveDay = 37000;
        int[][] dp = new int[n + 10][45];

        for (int i = 0; i < n + 10; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        boolean[] holiday = new boolean[n + 10];

        for (int x : arr) {
            holiday[x] = true;
        }

        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 43; j++) {
                if (dp[i][j] == Integer.MAX_VALUE / 2)
                    continue;

                // 휴일인 경우 이전 값에서 가져온다.
                if (holiday[i + 1]) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                }

                // 1일권
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + oneDay);

                // 3일권
                dp[i + 3][j + 1] = Math.min(dp[i + 3][j + 1], dp[i][j] + threeDay);

                // 5일권
                dp[i + 5][j + 2] = Math.min(dp[i + 5][j + 2], dp[i][j] + fiveDay);

                // 쿠폰 사용
                if (j >= 3) {
                    dp[i + 1][j - 3] = Math.min(dp[i + 1][j - 3], dp[i][j]);
                }

            }

        }

        int minCount = Integer.MAX_VALUE;
        for (int i = n; i <= n + 5; i++) {
            for (int j = 0; j < 43; j++) {
                minCount = Math.min(minCount, dp[i][j]);
            }
        }
        return minCount;
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

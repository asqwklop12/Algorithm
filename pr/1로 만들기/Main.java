import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        this.n = n;
        System.out.println(this.solve(n));
    }
    public int n;
    int min = Integer.MAX_VALUE;
    int[] dp = new int[1000001];

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n) {

        for (int k = 2; k <= n; k++) {
            dp[k] = dp[k - 1] + 1;

            if (k % 2 == 0) {
                dp[k] = Math.min(dp[k], dp[k / 2] + 1);
            }

            if (k % 3 == 0) {
                dp[k] = Math.min(dp[k], dp[k / 3] + 1);
            }

        }

        return dp[n];
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

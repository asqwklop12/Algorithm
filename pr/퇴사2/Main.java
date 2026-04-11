import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = fr.nextInt();
            p[i] = fr.nextInt();
        }

        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] <= n) {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

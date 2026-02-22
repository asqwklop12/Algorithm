import java.util.*;

public class Main {
    static int n;
    static long MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        long[][] result = null;

        for (int t = 0; t < n; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            long[][] cur = new long[x][y];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    cur[i][j] = sc.nextLong() % MOD;
                }
            }

            if (t == 0) {
                result = cur;
            } else {
                if (result[0].length != cur.length) {
                    System.out.println(-1);
                    return;
                }
                result = multiply(result, cur);
            }

        }

        long answer = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                answer = (answer + result[i][j]) % MOD;
            }
        }
        System.out.println(answer % MOD);

    }

    public static long[][] multiply(long[][] a, long[][] b) {
        int r = a.length;
        int m = a[0].length; // 공통 차원
        int c = b[0].length;

        long[][] res = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int k = 0; k < m; k++) {
                long av = a[i][k] % MOD;
                if (av == 0)
                    continue;
                for (int j = 0; j < c; j++) {
                    res[i][j] = (res[i][j] + av * (b[k][j] % MOD)) % MOD;
                }
            }
        }
        return res;
    }

}

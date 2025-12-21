import java.util.*;

public class Main {

    static class Meterial {
        int S;
        int B;

        public Meterial(int s, int b) {
            S = s;
            B = b;
        }
    }

    static int n;
    static int result = Integer.MAX_VALUE;
    static Meterial[] meterials;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        meterials = new Meterial[n];
        for (int i = 0; i < n; i++) {
            meterials[i] = new Meterial(sc.nextInt(), sc.nextInt());
        }
        solve();

    }

    public static void solve() {
        dfs(0, 1, 0, false);
        System.out.println(result);
    }

    public static void dfs(int idx, int s, int b, boolean used) {
        if (idx == n) {
            if (used) {
                result = Math.min(result, Math.abs(s - b));
            }
            return;
        }

        dfs(idx + 1, s * meterials[idx].S, b + meterials[idx].B, true);
        dfs(idx + 1, s, b, used);

    }

}

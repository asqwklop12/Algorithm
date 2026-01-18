import java.util.*;

public class Main {

    static int n;
    static int[] T;
    static int[] P;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        T = new int[n];
        P = new int[n];

        for (int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        solve();
    }

    public static void solve() {
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int day, int sum) {

        if (day == n) {
            max = Math.max(max, sum);
            return;
        }

        if (day + T[day] <= n) {
            dfs(day + 1, sum);
            dfs(day + T[day], sum + P[day]);
        } else {
            dfs(day + 1, sum);
        }

    }

}

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    // 0: +
    // 1: -
    // 2: *
    // 3: /
    static int[] op = new int[4];

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        solve();
        sc.close();
    }

    public static void solve() {
        dfs(op[0], op[1], op[2], op[3], 0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int plus, int minus, int multi, int div, int idx, int result) {

        if (idx == n - 1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        if (0 < plus) {
            dfs(plus - 1, minus, multi, div, idx + 1, result + arr[idx + 1]);
        }

        if (0 < minus) {
            dfs(plus, minus - 1, multi, div, idx + 1, result - arr[idx + 1]);
        }

        if (0 < multi) {
            dfs(plus, minus, multi - 1, div, idx + 1, result * arr[idx + 1]);
        }

        if (0 < div) {
            dfs(plus, minus, multi, div - 1, idx + 1, result / arr[idx + 1]);
        }

    }

}

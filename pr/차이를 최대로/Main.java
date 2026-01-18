import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
    }

    public static void solve() {

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(0, i, 0);
            visited[i] = false;
        }
        System.out.println(max);

    }

    public static void dfs(int depth, int pre, int sum) {

        if (depth == n - 1) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int result = Math.abs(arr[pre] - arr[i]);
            visited[i] = true;
            dfs(depth + 1, i, sum + result);
            visited[i] = false;
        }
    }
}

import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        result = new int[m];

        solve();
    }

    public static void solve() {
        dfs(0);

    }

    public static void dfs(int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            result[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}

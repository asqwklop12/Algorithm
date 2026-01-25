import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        result = new int[n + 1];

        solve();

    }

    public static void solve() {
        // 1부터 n까지의 수를 순회
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            result[0] = i;
            dfs(1, i);
            visited[i] = false;
        }

    }

    public static void dfs(int depth, int num) {
        if (depth == n) {

            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;
            result[depth] = i;
            visited[i] = true;
            dfs(depth + 1, i);
            visited[i] = false;
        }
    }

}
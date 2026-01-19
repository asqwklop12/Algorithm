import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
    }

    public static void solve() {

        dfs(0, 500);
        System.out.println(answer);

    }

    public static void dfs(int depth, int weight) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int nextWeight = weight + arr[i] - k;

            if (nextWeight < 500) {
                visited[i] = false;
                continue;
            } else {
                dfs(depth + 1, nextWeight);
            }
            visited[i] = false;
        }
    }

}

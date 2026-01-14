import java.util.*;

public class Main {

    static int n;
    static char[] arr;
    static boolean[] visited;

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new char[n];
        visited = new boolean[10];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        solve();
    }

    // 0 , 1, 2, 3, 4 , n-1

    public static void solve() {

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(0, i, i + "");
            visited[i] = false;
        }

        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    public static void dfs(int idx, int prev, String num) {
        if (idx == n) {
            result.add(num);
            return;
        }

        for (int cur = 0; cur < 10; cur++) {
            if (visited[cur])
                continue;
            visited[cur] = true;

            if (arr[idx] == '<' && prev < cur) {
                dfs(idx + 1, cur, num + cur);
            } else if (arr[idx] == '>' && prev > cur) {
                dfs(idx + 1, cur, num + cur);
            }

            visited[cur] = false;
        }

    }

}
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int cnt;

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
        System.out.println(cnt);

    }

    public static void solve() {
        dfs(0, 0);
    }

    public static void dfs(int idx, int sum) {

        if (idx == n) {
            return;
        }

        for (int i = idx; i < n; i++) {
            sum += arr[i];
            if (sum == m) {
                cnt++;
                break;
            }

            if (m < sum) {
                break;
            }

        }

        dfs(idx + 1, 0);

    }

}

import java.util.*;

public class Main {
    static int n;
    static int l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();

        solve();
    }

    public static void solve() {
        int temp = n / l;
        int sum = 0;

        for (int i = temp; i < temp + l; i++) {
            sum += i;
        }

        if (sum == n) {
            for (int i = 0; i < l; i++) {
                System.out.print((temp + i) + " ");
            }
        }
        if (n < sum) {
            dfs(temp - 1, l);
        }

    }

    public static void dfs(int num, int l) {
        if (num < 0 || l > 100) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        for (int i = num; i < num + l; i++) {
            sum += i;
        }

        if (sum == n) {
            for (int i = 0; i < l; i++) {
                System.out.print((num + i) + " ");
            }
            return;
        }
        if (n > sum) {
            dfs((n / (l + 1)), l + 1);
        }

        if (n < sum) {
            dfs(num - 1, l);
        }
    }
}
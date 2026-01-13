import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        solve();
    }

    // 0 , 1, 2, 3, 4 , n-1

    public static void solve() {

        for (int i = 1; i <= 3; i++) {
            dfs(0, String.valueOf(i));
        }
    }

    public static void dfs(int idx, String result) {
        if (isBad(result)) {
            return;
        }

        if (idx == n - 1) {
            System.out.println(result);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(idx + 1, result + String.valueOf(i));
        }

    }

    public static boolean isBad(String str) {
        int len = str.length();

        for (int i = 1; i <= len / 2; i++) {

            String after = str.substring(len - i);
            String before = str.substring(len - 2 * i, len - i);
            if (after.equals(before)) {
                return true;
            }
        }

        return false;
    }

}
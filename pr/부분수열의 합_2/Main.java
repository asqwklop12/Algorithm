import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    // N=20, max val=100,000 => Max sum = 2,000,000
    static boolean[] check = new boolean[2000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
    }

    public static void solve() {
        dfs(0, 0);

        // Find the smallest natural number (starting from 1)
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            check[sum] = true;
            return;
        }

        dfs(depth + 1, arr[depth] + sum);
        dfs(depth + 1, sum);

    }
}

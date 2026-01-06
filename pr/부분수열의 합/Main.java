import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int s;
    static int arr[];
    static int count = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();
        sc.close();
    }

    public static void solve() {
        dfs(0, 0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    public static void dfs(int idx, int sum) {
        // sum이 s와 같으면 return
        if (idx == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);

    }

}

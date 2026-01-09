import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] arr;

    static boolean[] checkNum = new boolean[10];

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        solve();
        sc.close();
    }

    public static void solve() {
        for (int i = 0; i < 10; i++) {
            checkNum[i] = true;
            dfs(0, i, i + "");
            checkNum[i] = false;
        }

        String mx = String.valueOf(max);

        while (mx.length() < n + 1) {
            mx = "0" + mx;
        }

        String mi = String.valueOf(min);

        while (mi.length() < n + 1) {
            mi = "0" + mi;
        }

        System.out.println(mx);
        System.out.println(mi);
    }

    public static void dfs(int idx, int prev, String num) {

        if (idx == n) {
            long n = Long.parseLong(num);
            min = Math.min(min, n);
            max = Math.max(max, n);
            return;
        }

        for (int cur = 0; cur < 10; cur++) {

            if (checkNum[cur])
                continue;

            if (arr[idx] == '<') {
                if (prev < cur) {
                    checkNum[cur] = true;
                    dfs(idx + 1, cur, num + cur);
                    checkNum[cur] = false;
                }
            }

            if (arr[idx] == '>') {
                if (prev > cur) {
                    checkNum[cur] = true;
                    dfs(idx + 1, cur, num + cur);
                    checkNum[cur] = false;
                }
            }

        }

    }

}
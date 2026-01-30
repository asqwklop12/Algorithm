import java.io.*;
import java.util.*;

public class Main {
    static int d;
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        d = sc.nextInt();
        k = sc.nextInt();
        solve();

    }

    public static void solve() {

        // ricecake[1] = // 1부터 시작해서 41개까지 2
        // ricecake[2] = // ricecake[1] + 1
        // ricecake[3] = ricecake[1] + ricecake[2];
        // ricecake[4] = ricecake[2] + ricecake[3];
        // ricecake[5] = ricecake[3] + ricecake[4];
        // ricecake[6] = ricecake[4] + ricecake[5];

        for (int i = 1; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (dfs(i, j, 3)) {
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }

    }

    public static boolean dfs(int ppre, int pre, int day) {
        if (ppre + pre > k) {
            return false;
        }

        if (day == d) {
            if (ppre + pre == k) {
                return true;
            }
            return false;
        }

        return dfs(pre, ppre + pre, day + 1);
    }

}
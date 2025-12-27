import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        solve();

    }

    public static void solve() {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = n; i <= m; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                result += i;
                min = Math.min(min, i);
            }
        }

        if (result == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
        System.out.println(min);
    }

}
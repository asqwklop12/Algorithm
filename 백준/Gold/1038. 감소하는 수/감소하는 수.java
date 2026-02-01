import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve();

    }
    // 11 -> 20 , 12 -> 21 13 -> 30, 14 -> 31, 15 -> 32, 16 -> 40

    public static void solve() {
        for (long i = 0; i <= 9; i++) {
            dfs(i);
        }

        if (n >= list.size()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(list);

        System.out.println(list.get(n));

    }

    public static void dfs(long num) {
        list.add(num);
        long last = num % 10;
        for (long i = last - 1; i >= 0; i--) {
            dfs(num * 10 + i);
        }
    }

}
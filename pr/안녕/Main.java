import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] health;
    static int[] happy;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        health = new int[n];

        for (int i = 0; i < n; i++) {
            health[i] = sc.nextInt();
        }

        happy = new int[n];

        for (int i = 0; i < n; i++) {
            happy[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {
        dfs(0, 100, 0);
        System.out.println(max);
    }

    static void dfs(int depth, int currentHealth, int currentHappy) {
        if (depth == n) {
            max = Math.max(max, currentHappy);
            return;
        }

        dfs(depth + 1, currentHealth, currentHappy);

        int nextHealth = currentHealth - health[depth];

        if (nextHealth > 0) {
            dfs(depth + 1, currentHealth - health[depth], currentHappy + happy[depth]);
        }

    }

}

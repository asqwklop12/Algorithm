import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int arr[][];

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solve();
        sc.close();
    }

    public static void solve() {
        dfs(0);
        System.out.println(min);
    }

    static List<Integer> team = new ArrayList<>();

    public static void dfs(int idx) {
        if (idx == n) {
            if (team.size() == n / 2) {
                int result = calculate();
                min = Math.min(min, result);
            }
            return;
        }
        team.add(idx);
        dfs(idx + 1);
        team.remove(team.size() - 1);
        dfs(idx + 1);
    }

    public static int calculate() {
        int start = 0;
        int link = 0;
        boolean[] isStart = new boolean[n];
        for (int i = 0; i < team.size(); i++) {
            isStart[team.get(i)] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isStart[i] && isStart[j]) {
                    start += (arr[i][j] + arr[j][i]);
                }

                if (!isStart[i] && !isStart[j]) {
                    link += (arr[i][j] + arr[j][i]);
                }

            }
        }

        return Math.abs(start - link);
    }

}

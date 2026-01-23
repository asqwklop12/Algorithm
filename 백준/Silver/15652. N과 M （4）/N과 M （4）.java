import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];

        solve();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void solve() {
        dfs(0, 1);

    }

    public static void dfs(int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static double[] arr;
    static double max = Double.MIN_VALUE;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        solve();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void solve() {

        for (int i = 0; i < n; i++) {
            dfs(i, 1.0);
        }
        System.out.printf("%.3f", max);
    }

    public static void dfs(int index, double result) {
        result *= arr[index];
        max = Math.max(max, result);

        if (index + 1 < n) {
            dfs(index + 1, result);
        }
    }

}
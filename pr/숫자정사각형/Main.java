import java.io.*;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[50][50];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        solve();

    }

    public static void solve() {

        if (N <= M) {
            dfs(N);
        } else {
            dfs(M);
        }

    }

    public static void dfs(int k) {
        if (k > N || k > M)
            return;

        for (int i = 0; i + k - 1 < N; i++) {
            for (int j = 0; j + k - 1 < M; j++) {
                if (arr[i][j] == arr[i][j + k - 1] &&
                        arr[i][j] == arr[i + k - 1][j] &&
                        arr[i][j] == arr[i + k - 1][j + k - 1]) {
                    System.out.println(k * k);
                    return;
                }

            }

        }

        dfs(k - 1);
    }

}

import java.util.*;

public class Main {

    static int n;
    static char[][] arr;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        solve();

    }

    public static void solve() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;
                    char t = arr[i][j];
                    arr[i][j] = arr[nx][ny];
                    arr[nx][ny] = t;
                    watch();
                    // 원상복구
                    arr[nx][ny] = arr[i][j];
                    arr[i][j] = t;

                }

            }

        }
        System.out.println(max);
    }

    // 일직선
    public static void watch() {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);

            }
            
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                 max = Math.max(max, count);
            }
           
        }
    }

}

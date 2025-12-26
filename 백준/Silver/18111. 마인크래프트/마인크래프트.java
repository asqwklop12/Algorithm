import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int inventory;

    static int[][] land;

    static int t = Integer.MAX_VALUE;
    static int ground;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inventory = Integer.parseInt(st.nextToken());

        land = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

    }

    public static void solve() {
        for (int h = 0; h <= 256; h++) {
            int block = inventory;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 땅의 크기가 지정된 높이보다 큰 경우
                    if (land[i][j] > h) {
                        int diff = land[i][j] - h;
                        // 예를 들어 diff가 2라면 4초가 소요됨
                        count += (diff * 2);
                        block += diff;
                    }

                    // 지정된 높이 보다 땅의 크기가 작은 경우
                    else if (land[i][j] < h) {
                        int diff = h - land[i][j];
                        count += diff;
                        block -= diff;
                    }
                }
            }
            if (block >= 0) {
                if (count <= t) {
                    t = count;
                    ground = h;
                }

            }
        }

        System.out.println(t + " " + ground);

    }

}
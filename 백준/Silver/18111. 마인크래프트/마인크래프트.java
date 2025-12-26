import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int inventory;

    static int[][] land;

    static int t = Integer.MAX_VALUE;
    static int ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inventory = Integer.parseInt(st.nextToken());

        land = new int[n][m];

        int max = -1;
        int min = 256;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, land[i][j]);
                min = Math.min(min, land[i][j]);
            }
        }

        solve(min, max);

    }

    public static void solve(int min, int max) {
        for (int h = min; h <= max; h++) {
            int block = inventory;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 땅이 크기가 지정된 높이보다 작으면 블럭을 채워야 한다.
                    // 인벤토리에서 꺼내야 한다.
                    if (land[i][j] < h) {
                        int diff = h - land[i][j];
                        time += diff;
                        block -= diff;

                        // 땅의 크기가 지정된 높이보다 크면 블럭을 제거해야 하고
                        // 인벤토리에 넣어야 한다.
                    } else if (land[i][j] > h) {
                        int diff = land[i][j] - h;
                        time += (diff * 2);
                        block += diff;
                    }
                }
            }

            // 블럭이 남아있다면
            if (block >= 0) {
                if (time <= t) {
                    t = time;
                    ground = h;
                }
            }
        }

        System.out.println(t + " " + ground);
    }

}
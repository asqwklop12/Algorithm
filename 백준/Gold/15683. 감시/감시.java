import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int min = Integer.MAX_VALUE;

    static class Cctv {
        int x;
        int y;
        int type;

        Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int[][][] mode = {
            { { 0 } }, // 0번 타입 (안 씀)
            { { 0 }, { 1 }, { 2 }, { 3 } }, // 1번: 한쪽
            { { 0, 2 }, { 1, 3 } }, // 2번: 양쪽(반대)
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3번: 직각
            { { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } }, // 4번: ㅗ 모양
            { { 0, 1, 2, 3 } } // 5번: 전방향
    };
    static ArrayList<Cctv> cctvList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new Cctv(i, j, map[i][j]));
                }
            }
        }
        solve();

    }

    public static void solve() {
        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int index) {

        if (index == cctvList.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }

            min = Math.min(min, count);
            return;
        }
        int[][] backupMap = new int[N][M];
        Cctv cctv = cctvList.get(index);
        for (int i = 0; i < N; i++) {
            backupMap[i] = map[i].clone();
        }
        for (int[] dirs : mode[cctv.type]) {

            // 타입 방향
            for (int dir : dirs) {
                watch(cctv.x, cctv.y, dir);
            }
            dfs(index + 1);
            for (int i = 0; i < N; i++) {
                map[i] = backupMap[i].clone();
            }
        }

    }

    public static void watch(int x, int y, int direction) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[direction];
            ny += dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                break;
            }

            if (map[nx][ny] == 6) {
                break;
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
            }
        }
    }
}
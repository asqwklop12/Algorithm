import java.io.*;
import java.util.*;

public class Main {
    static int c;
    static int r;
    static int k;
    static int[][] arr;
    static boolean[][] visited;
    // 상, 우, 하, 좌 순서 (시계 방향)
    static int[] dx = { 0, 1, 0, -1 }; // x축(열) 변화량
    static int[] dy = { 1, 0, -1, 0 }; // y축(행) 변화량

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        r = sc.nextInt();
        k = sc.nextInt();

        // k가 범위를 벗어나면 0 출력
        if (k > c * r) {
            System.out.println(0);
            return;
        }

        // 방문 여부 체크용 (1~C, 1~R 사용을 위해 크기 넉넉히)
        visited = new boolean[c + 2][r + 2];

        solve();
    }

    public static void solve() {
        int x = 1; // 문제의 시작 좌표 (1, 1)
        int y = 1;
        int dir = 0; // 0: 상, 1: 우, 2: 하, 3: 좌

        visited[x][y] = true; // 시작점 방문 처리

        for (int i = 0; i < k - 1; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나거나 이미 방문했으면 방향 전환
            if (nx < 1 || nx > c || ny < 1 || ny > r || visited[nx][ny]) {
                dir = (dir + 1) % 4; // 방향 회전
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            visited[x][y] = true;
        }

        System.out.println(x + " " + y);
    }

}

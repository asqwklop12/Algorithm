import java.util.*;

public class Main {

    static int[][] map = new int[19][19];
    static int[] dx = { 0, 1, 1, -1 };
    static int[] dy = { 1, 0, 1, 1 };

    static boolean win = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve();

        if (!win) {
            System.out.println(0);
        }

    }

    // 첫줄에 어떤 색이 이겼는지, (검정 1 흰색 2 무승부 0)
    // 승부가난 경우: 가장 첫번째 바둑알의 좌표 출력
    /*
     * 가로(→) -> 가장 왼쪽 (col 최소)
     * 세로(↓) -> 가장 위 (row 최소)
     * 대각선 ↘ -> 가장 위 + 가장 왼쪽
     * 대각선 ↗ -> 가장 아래 + 가장 왼쪽
     * (↗는 row가 커지니까, 탐색 시작점 기준으로는 아래가 “첫 돌”)
     */
    public static void solve() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 0)
                    continue;

                for (int dir = 0; dir < 4; dir++) {
                    int count = 1;

                    for (int k = 1; k <= 4; k++) {
                        int nx = i + dx[dir] * k;
                        int ny = j + dy[dir] * k;

                        if (nx < 0 || nx >= 19)
                            break;
                        if (ny < 0 || ny >= 19)
                            break;

                        if (map[i][j] != map[nx][ny])
                            break;
                        count++;

                        if (count == 5) {
                            // 앞칸 (i - dx, j - dy)
                            // 뒷칸 (i + 5*dx, j + 5*dy)

                            int frontX = i - dx[dir];
                            int frontY = j - dy[dir];

                            int backX = i + 5 * dx[dir];
                            int backY = j + 5 * dy[dir];

                            boolean isSix = false;

                            if (frontX >= 0 && frontX < 19 && frontY >= 0 && frontY < 19) {
                                if (map[frontX][frontY] == map[i][j])
                                    isSix = true;
                            }

                            if (backX >= 0 && backX < 19 && backY >= 0 && backY < 19) {
                                if (map[backX][backY] == map[i][j])
                                    isSix = true;
                            }

                            if (isSix)
                                continue; // 다음 dir

                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            win = true;
                            return;
                        }

                    }
                }
            }
        }
    }

}
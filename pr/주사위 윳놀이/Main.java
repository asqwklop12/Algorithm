import java.util.*;

public class Main {

    static int[] score = new int[33];
    static int[] next = new int[33];
    static int[] blue = new int[33];
    static int[] dice = new int[10];
    static int[] horse = new int[4]; // 말 4개의 위치 (0번 노드에서 시작)
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 게임판 초기화
        for (int i = 0; i < 21; i++) {
            next[i] = i + 1;
            score[i] = i * 2;
        }
        next[20] = 32; // 20번(40점) -> 도착(32)
        score[32] = 0;
        next[32] = 32; // 도착점

        // 파란색 화살표 (지름길 시작)
        blue[5] = 21;
        blue[10] = 24;
        blue[15] = 26;

        // 지름길 경로 (21~31번 노드)
        // 10 -> 13 -> 16 -> 19 -> 25
        score[21] = 13;
        next[21] = 22;
        score[22] = 16;
        next[22] = 23;
        score[23] = 19;
        next[23] = 29; // 25번 노드로

        // 20 -> 22 -> 24 -> 25
        score[24] = 22;
        next[24] = 25;
        score[25] = 24;
        next[25] = 29; // 25번 노드로

        // 30 -> 28 -> 27 -> 26 -> 25
        score[26] = 28;
        next[26] = 27;
        score[27] = 27;
        next[27] = 28;
        score[28] = 26;
        next[28] = 29; // 25번 노드로

        // 25 -> 30 -> 35 -> 40 -> 도착
        score[29] = 25;
        next[29] = 30;
        score[30] = 30;
        next[30] = 31;
        score[31] = 35;
        next[31] = 20; // 40점(20번 노드)으로

        // 2. 주사위 입력
        for (int i = 0; i < 10; i++) {
            dice[i] = sc.nextInt();
        }

        solve();
        System.out.println(ans);
    }

    public static void solve() {
        dfs(0, 0);
    }

    public static void dfs(int depth, int sum) {
        if (depth == 10) {
            ans = Math.max(ans, sum);
            return;
        }

        // 말 4개 중 하나를 선택해서 이동
        for (int i = 0; i < 4; i++) {
            // 현재 말의 위치를 구합니다.
            int current = horse[i];
            // 이동할 위치를 구합니다.
            int nextPos = current;

            int moveCount = dice[depth]; // 이번에 이동해야 할 칸 수
            if (blue[nextPos] != 0) {
                nextPos = blue[nextPos];
                moveCount--;
            }

            while (moveCount-- > 0) {
                nextPos = next[nextPos];
            }

            if (nextPos != 32 && isOccupied(nextPos))
                continue;
            horse[i] = nextPos;
            dfs(depth + 1, sum + score[nextPos]);
            horse[i] = current;
        }
    }

    static boolean isOccupied(int pos) {
        for (int i = 0; i < 4; i++) {
            if (horse[i] == pos)
                return true; // 누군가 있다!
        }
        return false; // 아무도 없다
    }

}

import java.util.*;

public class Main {
    static int[] player = new int[9];
    static boolean[] visited = new boolean[10];
    static int n;
    static int max = -1;

    static List<int[]> scoreList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] score = new int[9];
            for (int j = 0; j < 9; j++) {
                score[j] = sc.nextInt();
            }
            scoreList.add(score);
        }

        visited[1] = true;
        player[3] = 1;
        solve();
        System.out.println(max);

    }

    public static void solve() {
        dfs(0);
    }

    public static void dfs(int idx) {
        if (idx == 9) {
            max = Math.max(max, generateScore());
            return;
        }

        if (idx == 3) {
            dfs(idx + 1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            player[idx] = i;
            dfs(idx + 1);
            player[idx] = 0;
            visited[i] = false;
        }
    }

    public static int generateScore() {
        int score = 0;
        int batterIdx = 0;
        for (int i = 0; i < n; i++) {
            int out = 0;
            boolean base1 = false, base2 = false, base3 = false;

            while (out < 3) {
                int currentPlayer = player[batterIdx];
                int result = scoreList.get(i)[currentPlayer - 1];

                switch (result) {
                    case 1:
                        if (base3) {
                            score++;
                            base3 = false;
                        }

                        if (base2) {
                            base3 = true;
                            base2 = false;
                        }

                        if (base1) {
                            base2 = true;
                            base1 = false;
                        }

                        base1 = true;
                        break;
                    case 2:
                        // 이미 3루에 있는 경우
                        if (base3) {
                            base3 = false;
                            score++;
                        }
                        // 이미 2루에 있는 경우
                        if (base2) {
                            base2 = false;
                            score++;
                        }
                        // 이미 1루에 있는 경우
                        if (base1) {
                            base3 = true;
                            base1 = false;
                        }

                        base2 = true;
                        break;
                    case 3:
                        // 3루
                        if (base3) {
                            base3 = false;
                            score++;
                        }
                        // 2루
                        if (base2) {
                            base2 = false;
                            score++;
                        }
                        // 1루
                        if (base1) {
                            base1 = false;
                            score++;
                        }

                        base3 = true;
                        break;
                    case 4:
                        int temp = 1;

                        if (base1) {
                            temp++;
                            base1 = false;
                        }
                        if (base2) {
                            temp++;
                            base2 = false;
                        }
                        if (base3) {
                            temp++;
                            base3 = false;
                        }
                        score += temp;
                        break;
                    default:
                        out++;
                        break;
                }
                batterIdx = (batterIdx + 1) % 9;
            }

        }
        return score;
    }

}
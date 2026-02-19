import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;

    static int[][] arr;

    static int min = Integer.MAX_VALUE;

    static Op[] ops;
    static boolean[] visited;
    static int[] selected;

    static class Op {
        int r, c, s;

        public Op(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][m];
        ops = new Op[k];
        visited = new boolean[k];
        selected = new int[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            ops[i] = new Op(r, c, s);
        }

        solve();

    }

    public static void solve() {
        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == k) {
            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < k; i++) {
                rotate(copy, ops[selected[i]]);
            }

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += copy[i][j];
                }
                min = Math.min(min, sum);
            }

            return;
        }

        for (int i = 0; i < k; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            selected[depth] = i;
            dfs(depth + 1);
            visited[i] = false;

        }

    }

    public static void rotate(int[][] arr, Op op) {
        int r = op.r - 1;
        int c = op.c - 1;
        int s = op.s;

        // 중요: 가장 바깥쪽(s)만 돌리면 안 되고, 안쪽 사각형들도 같이 돌려야 합니다.
        for (int gap = 1; gap <= s; gap++) {
            // s 대신 gap을 사용해야 합니다.
            // 1. 왼쪽 위 값 저장
            int temp = arr[r - gap][c - gap];

            // 2. 왼쪽 줄 이동 (아래 -> 위) : OK (잘하셨어요)
            for (int i = r - gap; i < r + gap; i++) {
                arr[i][c - gap] = arr[i + 1][c - gap];
            }

            // 3. 아래 줄 이동 (오른쪽 -> 왼쪽) : OK (잘하셨어요)
            for (int i = c - gap; i < c + gap; i++) {
                arr[r + gap][i] = arr[r + gap][i + 1];
            }

            // 4. 오른쪽 줄 이동 (위 -> 아래) : 수정 필요
            // 현재 코드처럼 i++으로 돌면 위쪽 값이 계속 덮어씌워져서 망가집니다.
            // 아래쪽부터 채워야 하므로 i-- (역순)으로 돌아야 합니다.
            for (int i = r + gap; i > r - gap; i--) {
                arr[i][c + gap] = arr[i - 1][c + gap];
            }

            // 5. 위쪽 줄 이동 (왼쪽 -> 오른쪽) : 수정 필요
            // 마찬가지로 오른쪽부터 채워야 하므로 i-- (역순)으로 돌아야 합니다.
            for (int i = c + gap; i > c - gap; i--) {
                arr[r - gap][i] = arr[r - gap][i - 1];
            }

            // 6. 저장해둔 temp 값 넣기
            arr[r - gap][c - gap + 1] = temp;
        }
    }

}

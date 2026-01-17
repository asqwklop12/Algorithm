import java.util.*;

class Coin {
    int x;
    int y;
    String status;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = "none";
    }

    public void back(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void none() {
        this.status = "none";
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = "move";
    }

    public void drop() {
        this.status = "drop";
    }
}

public class Main {

    static int n;
    static int m;
    static char[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int answer = Integer.MAX_VALUE;
    static List<Coin> coins = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'o') {
                    coins.add(new Coin(i, j));
                }
            }
        }

        solve();
    }

    public static void solve() {
        Coin coin1 = coins.get(0);
        Coin coin2 = coins.get(1);
        dfs(coin1.x, coin1.y, coin2.x, coin2.y, 0);
    }

    public static void dfs(int x1, int y1, int x2, int y2, int depth) {
        if (depth == 10) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            boolean coin1Drop1 = false;

            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];
            boolean coin2Drop2 = false;

            if (nx1 < 0 || n <= nx1) {
                coin1Drop1 = true;
            }

            if (ny1 < 0 || m <= ny1) {
                coin1Drop1 = true;
            }

            if (nx2 < 0 || n <= nx2) {
                coin2Drop2 = true;
            }

            if (ny2 < 0 || m <= ny2) {
                coin2Drop2 = true;
            }

            // 둘다 떨어지면 안된다.
            if (coin1Drop1 && coin2Drop2) {
                continue;
            }

            // 같은 위치는 불가능하다.
            if (nx1 == nx2 && ny1 == ny2) {
                continue;
            }

            if (map[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }

            if (map[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            // 둘중 하나만 떨어져야 한다.
            if (coin1Drop1 && !coin2Drop2) {
                dfs(nx1, ny1, nx2, ny2, depth + 1);
            }

            if (!coin1Drop1 && coin2Drop2) {
                dfs(nx1, ny1, nx2, ny2, depth + 1);
            }

            dfs(nx1, ny1, nx2, ny2, depth + 1);

        }
    }

}

import java.util.*;

public class Main {
    static int n;
    static int m;

    static int[][] friends;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        friends = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        solve();

    }

    public static void solve() {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int length = bfs(i);

            if (length < min) {
                min = length;
                index = i;
            }
        }
        System.out.println(index);
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] friendShip = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        q.add(start);
        friendShip[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int other = 1; other <= n; other++) {
                if (friendShip[other])
                    continue;
                // 친구가 아니라면 넘어갑니다.
                if (friends[current][other] == 0)
                    continue;

                friendShip[other] = true;
                dist[other] = dist[current] + 1;
                q.add(other);
            }

        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dist[i];
        }
        return ans;
    }

}

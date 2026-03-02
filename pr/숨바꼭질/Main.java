import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new int[100001];

        Arrays.fill(visited, -1);

        solve();

    }

    public static void solve() {

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();

        visited[n] = 1;
        queue.add(n);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] m = { current + 1, current - 1, current * 2 };
            for (int x = 0; x < 3; x++) {
                int next = m[x];
                if (next < 0)
                    continue;
                if (next > 100000)
                    continue;

                // 이미 방문했었용
                if (visited[next] != -1)
                    continue;
                if (next == k) {
                    System.out.println(visited[current]);
                    return;
                }
                visited[next] = visited[current] + 1;
                queue.add(next);

            }
        }

    }

}

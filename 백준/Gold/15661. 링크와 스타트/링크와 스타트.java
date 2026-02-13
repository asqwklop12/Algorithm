import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int minScore = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve();

    }

    public static void solve() {
        for (int t = 1; t <= n / 2; t++) {
            dfs(0, 0, t);
        }

        System.out.println(minScore);
    }

    public static void dfs(int index, int count, int teamSize) {
        if (count == teamSize) {
            minScore = Math.min(minScore, calc());
            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(i + 1, count + 1, teamSize);
            visited[i] = false;
        }

    }

    public static int calc() {

        List<Integer> link = new ArrayList<>();
        List<Integer> start = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                link.add(i);
            } else {
                start.add(i);
            }
        }

        int linkScore = 0;
        int startScore = 0;

        for (int i = 0; i < link.size(); i++) {
            for (int j = 0; j < link.size(); j++) {
                linkScore += (map[link.get(i)][link.get(j)]);
            }
        }

        for (int i = 0; i < start.size(); i++) {
            for (int j = 0; j < start.size(); j++) {
                startScore += (map[start.get(i)][start.get(j)]);
            }
        }

        return Math.abs(linkScore - startScore);

    }

}
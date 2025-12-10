import java.util.*;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();

    static boolean[] visited;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();

                if (num == 1) {
                    houses.add(new Point(i, j));
                }
                if (num == 2) {
                    chickens.add(new Point(i, j));
                }

            }
        }
        visited = new boolean[chickens.size()];
        solve();
        System.out.println(result);
    }

    public static void solve() {
        dfs(0, 0);

    }

    public static void dfs(int start, int count) {
        if (count == M) {
            int totalDistance = 0;
            for (int i = 0; i < houses.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        Point chicken = chickens.get(j);
                        Point house = houses.get(i);
                        int distance = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
                totalDistance += minDistance;
            }
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
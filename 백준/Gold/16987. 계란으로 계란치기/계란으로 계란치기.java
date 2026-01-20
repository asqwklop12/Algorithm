import java.util.*;

class Egg {
    int health;
    int weight;

    public Egg(int health, int weight) {
        this.health = health;
        this.weight = weight;
    }
}

public class Main {

    static int n;
    static Egg[] eggs;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }

        solve();
    }

    public static void solve() {

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int count) {

        if (idx == n) {
            max = Math.max(max, count);
            return;
        }

        if (eggs[idx].health <= 0) {
            dfs(idx + 1, count);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < n; i++) {
            int c = 0;

            // 자기자신은 깨지지 않는다.
            if (idx == i) {
                continue;
            }

            // 이미 깨진 계란은 무시한다.
            if (eggs[i].health <= 0) {
                continue;
            }

            // 깨트린다.
            hit = true;

            eggs[idx].health -= eggs[i].weight;
            eggs[i].health -= eggs[idx].weight;

            // 깨뜨렸으면 기록
            if (eggs[i].health <= 0) {
                c++;
            }
            if (eggs[idx].health <= 0) {
                c++;
            }

            // 깨뜨렸으면 다음으로 넘어간다.
            dfs(idx + 1, count + c);

            eggs[idx].health += eggs[i].weight;
            eggs[i].health += eggs[idx].weight;

        }

        if (!hit) {
            dfs(idx + 1, count);
        }
    }

}
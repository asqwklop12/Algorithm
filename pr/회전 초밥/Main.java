import java.util.*;

public class Main {

    static int n;
    static int d;
    static int k;
    static int c;
    static int[] dish;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        dish = new int[n];

        for (int i = 0; i < n; i++) {
            dish[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {

        int max = 0;
        for (int i = 0; i < n; i++) {
            int uniqueCount = 0;
            boolean[] check = new boolean[3001];
            for (int j = 0; j < k; j++) {
                int idx = (i + j) % n;
                int sushiType = dish[idx];

                if (!check[sushiType]) {
                    check[sushiType] = true;
                    uniqueCount++;
                }

            }

            if (!check[c]) {
                uniqueCount++;
            }
            max = Math.max(max, uniqueCount);
        }

        System.out.println(max);

    }

}

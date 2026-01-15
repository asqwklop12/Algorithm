import java.util.*;

public class Main {

    static int n;
    static List<Integer> arr;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        solve();
    }

    // 0 , 1, 2, 3, 4 , n-1

    public static void solve() {
        dfs(0);
        System.out.println(max);

    }

    public static void dfs(int sum) {
        if (arr.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            int result = arr.get(i - 1) * arr.get(i + 1);

            int value = arr.get(i);
            arr.remove(i);
            dfs(result + sum);
            arr.add(i, value);
        }

    }

}
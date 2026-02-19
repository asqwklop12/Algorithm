import java.util.*;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static List<Integer> list;
    static List<Integer> maxList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        solve();

    }

    public static void solve() {
        first(n);

        System.out.println(max);

        for (int num : maxList) {
            System.out.print(num + " ");
        }
    }

    public static void first(int n) {
        // 두번째 수 구하기
        for (int i = 1; i <= n; i++) {
            list = new ArrayList<>();
            list.add(n);
            list.add(i);
            dfs(n, i);
        }

    }

    public static void dfs(int before, int current) {

        int next = before - current;

        if (next < 0) {
            if (max < list.size()) {
                max = list.size();
                maxList = new ArrayList<>(list);
            }
            return;
        }

        // 세번째 수 ~ ?번째수까지 구하기
        list.add(next);
        dfs(current, next);

    }

}
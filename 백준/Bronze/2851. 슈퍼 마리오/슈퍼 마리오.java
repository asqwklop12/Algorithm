import java.util.*;

public class Main {
    static int[] arr = new int[10];
    static int under100Max = Integer.MIN_VALUE;
    static int over100Min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {

        // 0번 인덱스부터 시작하는 모든 부분집합 탐색
        dfs(0, 0);

        if (100 - under100Max == over100Min - 100) {
            System.out.println(over100Min);
        } else if (100 - under100Max < over100Min - 100) {
            System.out.println(under100Max);
        } else {
            System.out.println(over100Min);
        }

    }

    public static void dfs(int index, int sum) {

        if (sum <= 100) {
            under100Max = Math.max(under100Max, sum);
        } else {
            over100Min = Math.min(over100Min, sum);
        }

        if (index == 10) {
            return;
        }

        dfs(index + 1, sum + arr[index]);
    }

}
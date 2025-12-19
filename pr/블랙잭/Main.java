import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                for (int k = 0; k < n; k++) {
                    if (i == k)
                        continue;
                    if (j == k)
                        continue;
                    sum = arr[i] + arr[j] + arr[k];

                    if (sum <= m) {
                        list.add(sum);
                    }
                }

            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

}

import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {
        int totalSum = 0;
        for (int i = 0; i < 9; i++) {
            totalSum += arr[i];

        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int temp = 0;
            for (int j = i + 1; j < 9; j++) {
                if (i == j)
                    continue;
                temp = arr[i] + arr[j];
                if (temp == totalSum - 100) {
                    list.add(arr[i]);
                    list.add(arr[j]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (list.contains(arr[i]))
                continue;
            System.out.println(arr[i]);
        }

    }

}

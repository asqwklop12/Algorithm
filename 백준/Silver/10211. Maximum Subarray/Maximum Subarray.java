import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
    }

    public static int solve(int[] arr) {
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            count = Math.max(count, dfs(arr, i, arr[i], arr[i]));
        }
        return count;
    }

    public static int dfs(int[] arr, int idx, int sum, int max) {
        if (idx == arr.length - 1) {
            return max;
        }

        int result = sum + arr[idx + 1];

        return dfs(arr, idx + 1, result, Math.max(max, result));
    }
}
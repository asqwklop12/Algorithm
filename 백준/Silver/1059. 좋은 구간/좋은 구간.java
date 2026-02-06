import java.util.*;

public class Main {
    static int l;
    static int arr[];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        n = sc.nextInt();

        solve();
    }

    public static void solve() {
        Arrays.sort(arr);

        for (int x : arr) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 1001; // 문제 조건상 최대보다 크게

        for (int x : arr) {
            if (x < n)
                left = x;
            else if (x > n) {
                right = x;
                break;
            }
        }
        int result = (n - left) * (right - n) - 1;
        System.out.println(result);

    }

}
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            solve(n, m);
        }
    }

    public static void solve(int n, int m) {
        long ans = 1;

        for (int i = 0; i < n; i++) {
            ans = ans * (m - i) / (i + 1);
        }

        System.out.println(ans);

    }

}

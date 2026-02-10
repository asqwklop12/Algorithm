import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            long result = solve(n);
            System.out.println(result);

        }

    }

    public static long solve(long n) {
        return dfs(n);
    }

    public static long dfs(long n) {
        if (isPrime(n)) {
            return n;
        }
        return dfs(n + 1);
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

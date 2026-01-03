import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        solve();

    }

    public static void solve() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += check(i);
        }
        System.out.println(count);
    }

    // 123 일의 자리는 3
    // 12
    public static int check(int num) {
        // 2자리 이하
        if (num < 100)
            return 1;

        int prev = num % 10;
        num /= 10;
        int curr = num % 10;
        num /= 10;

        int diff = curr - prev;

        while (num > 0) {
            int next = num % 10;
            num /= 10;

            if (next - curr != diff) {
                return 0;
            }

            curr = next;
        }

        return 1;
    }

}
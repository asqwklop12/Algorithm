import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int l;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();

        solve();

    }

    public static void solve() {

        for (int len = l; len <= 100; len++) {

            // N = len * x + len*(len-1)/2
            int tmp = n - (len * (len - 1)) / 2;

            // 시작값 x는 정수여야 함
            if (tmp < 0)
                continue;
            if (tmp % len != 0)
                continue;

            int x = tmp / len;

            // x는 0 이상
            if (x < 0)
                continue;

            // 출력
            for (int i = 0; i < len; i++) {
                System.out.print((x + i) + " ");
            }
            return;
        }
        // 못 찾으면
        System.out.println(-1);

    }

}

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        solve(p, q);

    }

    public static void solve(int N, int K) {
        // 약수를 구한다.
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
            if (count == K) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

}
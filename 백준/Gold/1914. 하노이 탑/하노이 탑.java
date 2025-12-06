import java.math.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int N = sc.nextInt();
            action(N);
        }
    }

    public static void action(int N) {
        // 1. Calculate and print total moves: 2^N - 1
        BigInteger count = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        System.out.println(count);

        // 2. Only print moves if N <= 20
        if (N <= 20) {
            hanoi(N, 1, 3, 2);
            System.out.print(sb);
        }
    }

    public static void hanoi(int n, int start, int target, int via) {
        if (n == 1) {
            sb.append(start).append(" ").append(target).append("\n");
            return;
        }

        hanoi(n - 1, start, via, target);
        sb.append(start).append(" ").append(target).append("\n");
        hanoi(n - 1, via, target, start);
    }
}

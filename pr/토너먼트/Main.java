import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int kim = sc.nextInt();
        int im = sc.nextInt();
        solve(1, n, kim, im);

    }

    public static void solve(int count, int total, int kim, int im) {
        // 1 ~n명 (1vs 2 3 vs 4 ....)
        int nextKim = (kim + 1) / 2;
        int nextIm = (im + 1) / 2;

        if (nextKim == nextIm) {
            System.out.println(count);
            return;
        }

        solve(count + 1, total, nextKim, nextIm);
    }

}

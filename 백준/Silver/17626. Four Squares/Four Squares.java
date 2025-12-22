import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve();

    }

    public static void solve() {
        int count = -1;
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n == (i * i)) {
                count = 1;
                break;
            }

            for (int j = 1; j <= Math.sqrt(n - (i * i)); j++) {

                // 이미 count가 1이면 탈출
                if (count == 1) {
                    break;
                }

                if ((n - (i * i)) == (j * j)) {
                    count = 2;
                    break;
                }

                for (int k = 1; k <= Math.sqrt(n - (i * i) - (j * j)); k++) {

                    if (count == 1 || count == 2) {
                        break;
                    }

                    if ((n - (i * i) - (j * j)) == (k * k)) {
                        count = 3;
                        break;
                    }

                }
            }

        }

        if (count == -1) {
            count = 4;
        }

        System.out.println(count);
    }

}
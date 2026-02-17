import java.util.*;

public class Main {
    static int[] arr = new int[5];

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int lcm = lcm(arr[i], arr[j], arr[k]);
                    min = Math.min(min, lcm);
                }
            }
        }

        System.out.println(min);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int lcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }

}
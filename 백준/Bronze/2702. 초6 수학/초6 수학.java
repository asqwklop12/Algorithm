import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] result = solve(a, b);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] solve(int a, int b) {
        int gcd = 0;
        int lcm = 0;

        for (int i = 1; i <= a * b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        lcm = a * b / gcd;

        return new int[] { lcm, gcd };
    }

}
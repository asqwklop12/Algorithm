import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        solve();

    }

    public static void solve() {
        for (int i = n;; i++) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean isPalindrome(int num) {
        return String.valueOf(num).equals(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}

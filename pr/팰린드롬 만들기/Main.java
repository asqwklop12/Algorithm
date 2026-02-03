import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        solve();

    }

    public static void solve() {
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            action(left, right);
        }
        System.out.println(min);
    }

    public static void action(String left, String right) {
        // 일단 right가 팰린드롬이어야 한다.
        if (isPalindrom(right)) {
            min = Math.min(min, left.length() * 2 + right.length());
        }
    }

    public static boolean isPalindrom(String right) {
        int mid = right.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (right.charAt(i) != right.charAt(right.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}

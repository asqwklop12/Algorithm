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

        for (int i = n; i > 0; i--) {
            if (minsu(i)) {
                System.out.println(i);
                break;

            }
        }
    }

    public static boolean minsu(int num) {
        String str = String.valueOf(num);
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (t != '4' && t != '7') {
                flag = false;
                break;
            }

        }

        return flag;
    }

}
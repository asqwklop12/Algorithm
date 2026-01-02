import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        solve(n, f);

    }

    public static void solve(int n, int f) {
        int temp = (n / 100);

        for (int i = 0; i < 100; i++) {
            int a = 0;

            if (i < 10) {
                a = Integer.parseInt(temp + "0" + i);
            } else {
                a = Integer.parseInt(temp + String.valueOf(i));
            }
            if (a % f == 0) {

                String str = String.valueOf(a);

                System.out.println(str.substring(str.length() - 2));
                return;
            }
        }

    }

}

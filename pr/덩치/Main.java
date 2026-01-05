import java.io.*;
import java.util.*;

public class Main {

    static class P {
        int h;
        int w;

        P(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    static int n;
    static P[] p;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = new P[n];

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            p[i] = new P(h, w);
        }
        solve();
        sc.close();
    }

    public static void solve() {
        // 1번 부터 n번까지
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                // 자기 자신은 계산하지 않는다.
                if (i == j)
                    continue;
                if (p[i].h < p[j].h && p[i].w < p[j].w) {
                    count++;
                }
            }
            result[i] = count + 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }

}

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        solve();

    }

    public static void solve() {

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean[] check = new boolean[n];
            check[i] = true;
            for (int f = 0; f < n; f++) {
                if (map[i][f] == 'N')
                    continue;
                check[f] = true;
                count++;
            }

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'N')
                    continue;
                for (int ff = 0; ff < n; ff++) {
                    if (check[ff])
                        continue;
                    if (map[j][ff] == 'N')
                        continue;
                    check[ff] = true;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] friends = new String[N];
            for (int i = 0; i < N; i++) {
                friends[i] = st.nextToken();
            }

            solve(N, friends);
        }

    }

    public static void solve(int n, String[] friends) {
        int result = Integer.MAX_VALUE;

        if (n > 32) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int dist = distance(friends[i], friends[j]) +
                            distance(friends[i], friends[k]) +
                            distance(friends[j], friends[k]);

                    result = Math.min(result, dist);
                }
            }

        }

        System.out.println(result);

    }

    static int distance(String a, String b) {
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i))
                d++;
        }
        return d;
    }
}
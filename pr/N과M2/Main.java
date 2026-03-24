import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastReader fr = new FastReader();
        int n = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        this.solve(n, m);
    }

    int n;
    int m;
    int[] res;
    boolean[] visited;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int m) {
        this.n = n;
        this.m = m;
        this.res = new int[m];
        this.visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) { // 1,2,3,4
            res[0] = i + 1;
            visited[i] = true;
            dfs(i + 1, 1);
            visited[i] = false;
        }
        return 0;
    }

    public void dfs(int start, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (visited[i])
                continue;

            res[count] = i + 1;
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public boolean hasMoreTokens() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                if (line == null)
                    return false;
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}

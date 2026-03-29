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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(fr.next());
        }
        int[][] queries = new int[m][2];
        for (int i = 0; i < m; i++) {
        queries[i][0] = Integer.parseInt(fr.next());
        queries[i][1] = Integer.parseInt(fr.next());
        }
        int[] res = this.solve(n, m, arr, queries);
        StringBuilder _sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {{
        _sb.append(res[i]).append(" ");
        }}
        System.out.println(_sb.toString().trim());
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int[] solve(int n, int m, int[] arr, int[][] queries) {

        int[] prefix = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int sum = prefix[end] - prefix[start - 1];
            ans[i] = sum;
        }

        return ans;
    }

    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { } } return st.nextToken(); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public boolean hasMoreTokens() { while (st == null || !st.hasMoreElements()) { String line = null; try { line = br.readLine(); } catch (IOException e) { } if (line == null) return false; st = new StringTokenizer(line); } return true; }
    }
}

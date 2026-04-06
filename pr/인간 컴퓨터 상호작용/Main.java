import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                String S = fr.next();
        int q = Integer.parseInt(fr.next());
        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
        queries[i][0] = fr.next().charAt(0);
        queries[i][1] = Integer.parseInt(fr.next());
        queries[i][2] = Integer.parseInt(fr.next());
        }
        int[] res = this.solve(S, q, queries);
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
    public int[] solve(String S, int q, int[][] queries) {

        int[][] prefix = new int[26][S.length() + 1];

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= S.length(); j++) {
                int alpha = S.charAt(j - 1) - 'a';
                if (alpha == i) {
                    prefix[i][j] = prefix[i][j - 1] + 1;
                } else {
                    prefix[i][j] = prefix[i][j - 1];
                }

            }

        }

        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            int alpha = queries[i][0] - 'a';
            int l = queries[i][1];
            int r = queries[i][2];

            res[i] = prefix[alpha][r + 1] - prefix[alpha][l];

        }

        return res;
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

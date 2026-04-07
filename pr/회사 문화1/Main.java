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
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        parents[i] = Integer.parseInt(fr.next());
        }
        int[][] compliments = new int[m][2];
        for (int i = 0; i < m; i++) {
        compliments[i][0] = Integer.parseInt(fr.next());
        compliments[i][1] = Integer.parseInt(fr.next());
        }
        long[] res = this.solve(n, m, parents, compliments);
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
    public List<Integer>[] adjust;
    public long[] ans;

    public long[] solve(int n, int m, int[] parents, int[][] compliments) {

        adjust = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjust[i] = new ArrayList<>();
        }

        ans = new long[n + 1];

        for (int j = 0; j < m; j++) {
            int target = compliments[j][0];
            int amount = compliments[j][1];
            ans[target] += amount;
        }

        for (int i = 1; i <= n; i++) {
            if (parents[i] == -1)
                continue;
            adjust[parents[i]].add(i);

        }

        dfs(1);

        long[] res = new long[n];
        for (int i = 1; i < ans.length; i++) {
            res[i - 1] = ans[i];
        }

        return res;
    }

    public void dfs(int current) {
        for (int child : adjust[current]) {
            ans[child] += ans[current];
            dfs(child);
        }
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

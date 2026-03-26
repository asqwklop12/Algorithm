import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int[][] grid = new int[n - 1][4];
        for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < 4; j++)
        grid[i][j] = Integer.parseInt(fr.next());
        long[] res = this.solve(n, grid);
        StringBuilder _sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {{
        _sb.append(res[i]).append(" ");
        }}
        System.out.println(_sb.toString().trim());
    }
    class Edge {
        int to;
        int p;
        int q;

        Edge(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    boolean[] visited;
    long lcm;
    List<Edge>[] adj;
    long[] ans;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public long[] solve(int n, int[][] grid) {
        adj = new List[n];
        visited = new boolean[n];
        ans = new long[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = grid[i][0];
            int v = grid[i][1];
            int p = grid[i][2];
            int q = grid[i][3];
            adj[u].add(new Edge(v, p, q));
            adj[v].add(new Edge(u, q, p));
        }

        lcm = 1;

        for (int i = 0; i < n - 1; i++) {
            lcm *= grid[i][2] * grid[i][3];
        }

        ans[0] = lcm;
        dfs(0);

        long g = ans[0];

        for (int i = 1; i < n; i++) {
            g = gcd(g, ans[i]);
        }

        for (int i = 0; i < n; i++) {
            ans[i] /= g;
        }
        return ans;
    }

    public void dfs(int current) {
        visited[current] = true;
        for (Edge edge : adj[current]) {
            if (visited[edge.to])
                continue;

            ans[edge.to] = ans[current] * edge.q / edge.p;
            dfs(edge.to);
        }

    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        String input = sb.toString().trim();
        Solution sol = new Solution();
        Parse parser = new Parse();
        String result = parser.parseAndCallSolve(sol, input);
        System.out.println(result);
    }
}

// ===== Solution =====

class Solution {
    public static class Edge {
        public final int from;
        public final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    int n;
    int[] populations;
    Integer[][] dp;
    List<Integer>[] adj;

    public int solve(int n, int[] populations, Edge[] edges) {
        this.n = n;
        this.populations = populations;
        this.adj = new List[n + 1];
        this.dp = new Integer[n + 1][2];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            adj[edge.from].add(edge.to);
            adj[edge.to].add(edge.from);
        }

        return dfs(1, 0, false);
    }

    public int dfs(int cur, int parent, boolean isParentSelected) {

        int notSelectedSum = 0;

        int state = isParentSelected ? 1 : 0;

        if (dp[cur][state] != null) {
            return dp[cur][state];
        }

        for (int next : adj[cur]) {
            if (next == parent)
                continue;
            notSelectedSum += dfs(next, cur, false);
        }

        int selectedSum = 0;

        if (!isParentSelected) {
            selectedSum = populations[cur];

            for (int next : adj[cur]) {
                if (next == parent)
                    continue;
                selectedSum += dfs(next, cur, true);
            }
        }

        return dp[cur][state] = Math.max(notSelectedSum, selectedSum);
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());

        int[] populations = new int[n + 1];
        for (int village = 1; village <= n; village++) {
            populations[village] = Integer.parseInt(st.nextToken());
        }

        Solution.Edge[] edges = new Solution.Edge[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[i] = new Solution.Edge(from, to);
        }

        return String.valueOf(sol.solve(n, populations, edges));
    }
}

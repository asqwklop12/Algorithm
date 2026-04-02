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

    public int[] solve(int n, Edge[] edges) {

        List<Integer>[] adj = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n + 1];

        for (Edge edge : edges) {
            adj[edge.from].add(edge.to);
            inDegree[edge.to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] answer = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            answer[idx++] = cur;
            for (int next : adj[cur]) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    q.add(next);
                }

            }
        }

        return answer;
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Solution.Edge[] edges = new Solution.Edge[m];
        for (int i = 0; i < m; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[i] = new Solution.Edge(from, to);
        }

        int[] result = sol.solve(n, edges);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}

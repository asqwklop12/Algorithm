import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int[] source;
    int[] target;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        this.source = source;
        this.target = target;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] swap : allowedSwaps) {
            int a = swap[0];
            int b = swap[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<Integer> component = new ArrayList<>();
            dfs(i, component);

            Map<Integer, Integer> count = new HashMap<>();

            for (int idx : component) {
                count.put(source[idx], count.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : component) {
                int val = target[idx];
                if (count.getOrDefault(val, 0) > 0) {
                    count.put(val, count.get(val) - 1);
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(int cur, List<Integer> component) {
        visited[cur] = true;
        component.add(cur);

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, component);
            }
        }
    }
}

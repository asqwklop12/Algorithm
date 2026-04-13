import java.io.*;
import java.util.*;

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
        parser.parseAndCallSolve(sol, input);
    }
}

// ===== Solution =====

class Solution {
    int n;
    int m;
    int[] nums;

    int[] selected;
    boolean[] visited;

    Set<String> set;

    public void solve(int m, int[] nums) {
        this.n = nums.length;
        this.m = m;
        this.nums = nums;
        visited = new boolean[n];
        selected = new int[m];

        set = new LinkedHashSet<>();

        Arrays.sort(nums);

        dfs(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    public void dfs(int index) {
        if (index == m) {

            StringBuilder sb = new StringBuilder();
            for (int a : selected) {
                sb.append(a + " ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            selected[index] = nums[i];
            // 백트래킹
            visited[i] = true;
            dfs(index + 1);
            visited[i] = false;

        }
    }
}

// ===== Parse =====

class Parse {
    public void parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol.solve(m, nums);
    }
}

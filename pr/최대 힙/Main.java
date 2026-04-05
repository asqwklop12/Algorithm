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
    public int[] solve(int[] operations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        List<Integer> ans = new ArrayList<>();
        for (int op : operations) {
            if (op == 0) {
                if (pq.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(pq.poll());
                }
            } else {
                pq.add(op);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int q = Integer.parseInt(st.nextToken());
        int[] operations = new int[q];
        for (int i = 0; i < q; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = sol.solve(operations);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append('\n');
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}

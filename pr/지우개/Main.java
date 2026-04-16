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
    public int solve(int n) {

        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        // 1 2 3 4 5

        while (arr.length > 1) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                // 홀수 자리인 경우
                if (i % 2 != 0) {
                    list.add(arr[i]);
                }
            }

            arr = list.stream().mapToInt(i -> i).toArray();
        }

        return arr[0];
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        return String.valueOf(sol.solve(n));
    }
}

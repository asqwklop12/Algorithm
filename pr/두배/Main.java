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
    int n;

    public long solve(int[] nums) {
        this.n = nums.length;

        long totalCount = 0;
        int[] counts = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                int k = 0;
                int temp = nums[i];
                while (temp < nums[i - 1]) {
                    temp *= 2;
                    k++;
                }
                counts[i] = counts[i - 1] + k;
            } else {
                int k = 0;
                int temp = nums[i - 1];
                while (temp * 2 <= nums[i]) {
                    temp *= 2;
                    k++;
                }
                counts[i] = Math.max(0, counts[i - 1] - k);
            }
        }

        for (int count : counts) {
            totalCount += count;
        }

        return totalCount;

    }

}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return String.valueOf(sol.solve(nums));
    }
}

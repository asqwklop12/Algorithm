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
    public static class SubmatrixQuery {
        public final int topRow;
        public final int leftCol;
        public final int bottomRow;
        public final int rightCol;

        public SubmatrixQuery(int topRow, int leftCol, int bottomRow, int rightCol) {
            this.topRow = topRow;
            this.leftCol = leftCol;
            this.bottomRow = bottomRow;
            this.rightCol = rightCol;
        }
    }

    int n;
    int m;

    public int[] solve(int[][] board, SubmatrixQuery[] queries) {
        n = board.length;
        m = board[0].length;

        int[][] prefixSum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i + 1][j + 1] = board[i][j] +
                        prefixSum[i][j + 1] +
                        prefixSum[i + 1][j] -
                        prefixSum[i][j];
            }
        }

        List<Integer> result = new ArrayList<>();

        for (SubmatrixQuery q : queries) {

            int i = q.topRow;
            int j = q.leftCol;

            int x = q.bottomRow;
            int y = q.rightCol;

            int sum = prefixSum[x][y]
                    - prefixSum[x][j - 1]
                    - prefixSum[i - 1][y]
                    + prefixSum[i - 1][j - 1];

            result.add(sum);

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(st.nextToken());
        Solution.SubmatrixQuery[] queries = new Solution.SubmatrixQuery[k];
        for (int i = 0; i < k; i++) {
            int topRow = Integer.parseInt(st.nextToken());
            int leftCol = Integer.parseInt(st.nextToken());
            int bottomRow = Integer.parseInt(st.nextToken());
            int rightCol = Integer.parseInt(st.nextToken());
            queries[i] = new Solution.SubmatrixQuery(topRow, leftCol, bottomRow, rightCol);
        }

        int[] result = sol.solve(board, queries);
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

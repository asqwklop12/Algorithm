import java.io.*;
import java.util.*;
import java.util.*;;
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
    public enum Operation {
        ALLIANCE, WAR
    }

    public static class Record {
        public final Operation operation;
        public final int countryA;
        public final int countryB;

        public Record(Operation operation, int countryA, int countryB) {
            this.operation = operation;
            this.countryA = countryA;
            this.countryB = countryB;
        }
    }

    public static class Result {
        public final int remainingCountryCount;
        public final int[] remainingArmies;

        public Result(int remainingCountryCount, int[] remainingArmies) {
            this.remainingCountryCount = remainingCountryCount;
            this.remainingArmies = remainingArmies;
        }
    }

    int[] parent;

    public Result solve(int n, int m, int[] countryArmies, Record[] records) {

        List<Integer> result = new ArrayList<>();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (Record record : records) {
            Operation op = record.operation;
            int countryA = record.countryA;
            int countryB = record.countryB;

            int rootA = find(countryA - 1);
            int rootB = find(countryB - 1);

            // 동맹인 경우
            if (op == Operation.ALLIANCE) {
                union(rootA, rootB);
                countryArmies[rootB] += countryArmies[rootA];

                // 전쟁인 경우
            } else {
                if (rootA != rootB) {
                    // A의 병력이 더 강한 경우
                    if (countryArmies[rootA] > countryArmies[rootB]) {
                        union(rootB, rootA);
                        countryArmies[rootA] -= countryArmies[rootB];
                        // B의 병력이 더 강한 경우
                    } else if (countryArmies[rootA] < countryArmies[rootB]) {
                        union(rootA, rootB);
                        countryArmies[rootB] -= countryArmies[rootA];
                        // 병력이 같은 경우
                    } else {
                        union(rootA, rootB);
                        countryArmies[rootB] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i && countryArmies[i] > 0) {
                result.add(countryArmies[i]);
            }
        }
        Collections.sort(result);
        return new Result(result.size(), result.stream().mapToInt(i -> i).toArray());
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] countryArmies = new int[n];
        for (int i = 0; i < n; i++) {
            countryArmies[i] = Integer.parseInt(st.nextToken());
        }

        Solution.Record[] records = new Solution.Record[m];
        for (int i = 0; i < m; i++) {
            int operation = Integer.parseInt(st.nextToken());
            int countryA = Integer.parseInt(st.nextToken());
            int countryB = Integer.parseInt(st.nextToken());
            Solution.Operation parsedOperation = operation == 1 ? Solution.Operation.ALLIANCE : Solution.Operation.WAR;
            records[i] = new Solution.Record(parsedOperation, countryA, countryB);
        }

        Solution.Result result = sol.solve(n, m, countryArmies, records);
        StringBuilder sb = new StringBuilder();
        sb.append(result.remainingCountryCount).append('\n');
        if (result.remainingArmies.length > 0) {
            for (int i = 0; i < result.remainingArmies.length; i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(result.remainingArmies[i]);
            }
        }
        return sb.toString();
    }
}

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> solve(int g) {
        List<Integer> answer = new ArrayList<>();

        int curent = 2;
        int past = 1;

        while (past < curent) {
            int diff = (curent * curent) - (past * past);
            if (diff == g) {
                answer.add(curent);
                curent++;
                past++;
            } else if (diff < g) {
                curent++;
            } else {
                past++;
            }
        }

        return answer;

    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int g = Integer.parseInt(st.nextToken());
        List<Integer> answer = sol.solve(g);
        if (answer == null || answer.isEmpty()) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            if (i > 0) {
                sb.append('\n');
            }
            sb.append(answer.get(i));
        }
        return sb.toString();
    }
}

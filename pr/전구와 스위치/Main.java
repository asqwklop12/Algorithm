import java.io.*;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        String current = fr.next();
        String target = fr.next();
        System.out.println(this.solve(n, current, target));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */

    public int solve(int n, String current, String target) {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] targetArr = new int[n];
        for (int i = 0; i < n; i++) {
            int val = current.charAt(i) - '0';
            arr1[i] = val;
            arr2[i] = val;
            targetArr[i] = target.charAt(i) - '0';
        }
        // Case 1: 0번 안 누르고 출발 (카운트 0)
        int ans1 = simulate(n, arr1, targetArr, 0, false);
        // Case 2: 0번 무조건 누르고 출발 (카운트 1)
        int ans2 = simulate(n, arr2, targetArr, 1, true);
        if (ans1 == -1 && ans2 == -1)
            return -1;
        if (ans1 == -1)
            return ans2;
        if (ans2 == -1)
            return ans1;
        return Math.min(ans1, ans2);
    }

    private int simulate(int n, int[] curr, int[] target, int count, boolean pressZero) {
        // 첫 시작 세팅
        if (pressZero) {
            curr[0] = 1 - curr[0];
            if (n > 1)
                curr[1] = 1 - curr[1];
        }
        // 이후 로직은 동일
        for (int i = 1; i < n; i++) {
            if (curr[i - 1] != target[i - 1]) {
                count++;
                curr[i - 1] = 1 - curr[i - 1]; // 자신
                curr[i] = 1 - curr[i]; // 다음
                if (i + 1 < n) {
                    curr[i + 1] = 1 - curr[i + 1]; // 다다음
                }
            }
        }
        if (curr[n - 1] == target[n - 1])
            return count;
        return -1;
    }

    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { } } return st.nextToken(); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public boolean hasMoreTokens() { while (st == null || !st.hasMoreElements()) { String line = null; try { line = br.readLine(); } catch (IOException e) { } if (line == null) return false; st = new StringTokenizer(line); } return true; }
    }
}

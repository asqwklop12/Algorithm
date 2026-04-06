import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(fr.next());
        System.out.println(this.solve(n, m, arr));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int m, int[] arr) {

        // 3 -2 -4 -9 0 3 7 13 8 -3
        // arr[0] + arr[1] = 1
        // arr[1] + arr[2] = -6
        // arr[2] + arr[3] = -13
        // arr[3] + arr[4] = -9
        // arr[4] + arr[5] = 3
        // arr[5] + arr[6] = 10
        // arr[6] + arr[7] = 20
        // arr[7] + arr[8] = 21
        // arr[8] + arr[9] = 5

        int[] prefix = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        // 0 3 1 -3 -12 -12 -9 -2 11 19 16
        // prefix[2] - prefix[0] = 1
        // preifx[3] - prefix[1] = -4
        // prefix[4] - prefix[2] = -13
        // prefix[5] - prefix[3] = -9
        // prefix[6] - prefix[4] = 3
        // prefix[7] - prefix[5] = 10
        // prefix[8] - prefix[6] = 20
        // prefix[9] - prefix[7] = 21
        // prefix[10] - prefix[8] = 5

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - m + 1; i++) {
            int sum = prefix[i + m] - prefix[i];
            if (max < sum) {
                max = sum;
            }
        }

        return max;
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

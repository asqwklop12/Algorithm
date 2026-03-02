import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(fr.next());
        this.n = n;
        this.arr = arr;
        System.out.println(this.solve(n, arr));
    }
    public int n;
    public long[] arr;
    public long max = Long.MIN_VALUE;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public long solve(int n, long[] arr) {
        for (int i = 0; i < n; i++) {
            long total = left(i) + right(i);
            max = Math.max(max, total);
        }

        return max;
    }

    public long right(int cur) {
        int count = 0;
        double maxSlope = Double.MIN_VALUE;
        for (int next = cur + 1; next < n; next++) {
            double slope = (double) (arr[next] - arr[cur]) / (next - cur);
            if (next == cur + 1 || maxSlope < slope) {
                count++;
                maxSlope = slope;
            }
        }

        return count;
    }

    public long left(int cur) {
        int count = 0;
        double minScope = Double.MAX_VALUE;
        for (int prev = cur - 1; prev >= 0; prev--) {
            double slope = (double) (arr[prev] - arr[cur]) / (prev - cur);

            if (prev == cur - 1 || minScope > slope) {
                count++;
                minScope = slope;
            }
        }
        return count;
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

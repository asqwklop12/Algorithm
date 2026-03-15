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
    int n;
    int m;
    int[] arr;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int m, int[] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr;
        long low = 1;
        long high = Integer.MAX_VALUE;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }

        }

        return (int) ans;
    }

    private boolean check(long x) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (arr[i] / x);
        }

        return count >= m;
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

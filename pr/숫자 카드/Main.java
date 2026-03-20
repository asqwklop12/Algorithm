import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        int[] targets = new int[m];
        for(int i=0; i<m; i++) targets[i] = Integer.parseInt(fr.next());
        int[] res = this.solve(n, arr, m, targets);
        StringBuilder _sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {{
        _sb.append(res[i]).append(" ");
        }}
        System.out.println(_sb.toString().trim());
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int[] solve(int n, int[] arr, int m, int[] targets) {
        Arrays.sort(arr);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == targets[i]) {
                    ans[i] = 1;
                    break;
                } else if (arr[mid] < targets[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
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

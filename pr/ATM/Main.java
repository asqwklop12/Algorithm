import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int[] arr = new int[n];
        for (int j = 0; j < n; j++)
        arr[j] = Integer.parseInt(fr.next());
        this.n = n;
        this.arr = arr;
        System.out.println(this.solve(n, arr));
    }
    public int n;
    public int[] arr;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int[] arr) {
        Arrays.sort(arr);

        // 0, (0,1) (0,1,2)....
        int total = arr[0];
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prev += arr[i];
            total += prev;
        }

        return total;
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

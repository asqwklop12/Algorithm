import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        this.n = n;
        System.out.println(this.solve(n));
    }
    public int n;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n) {

        // 택희: x, 영훈: y, 남규: z
        // 영훈 >= 남규 + 2
        // 택희는 짝수
        return dfs();
    }

    public int dfs() {
        int count = 0;
        for (int x = 2; x <= n; x++) { // 2,4,6
            if (x % 2 != 0)
                continue;
            int rem = n - x; // 5,3,1
            for (int y = 1; y <= rem; y++) {
                for (int z = 1; z <= rem - y; z++) {
                    if (y >= z + 2 && (x + y + z) == n) {
                        count++;
                    }
                }

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

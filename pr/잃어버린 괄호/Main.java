import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                String expression = fr.next();
        this.expression = expression;
        System.out.println(this.solve(expression));
    }
    public String expression;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(String expression) {

        String[] arr = expression.split("-");
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            String[] plus = arr[i].split("\\+");
            for (String s : plus) {
                sum += Integer.parseInt(s);
            }

            if (i == 0)
                ans += sum;
            else
                ans -= sum;
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

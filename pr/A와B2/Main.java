import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                String a = fr.next();
        String b = fr.next();
        this.a = a;
        this.b = b;
        System.out.println(this.solve(a, b));
    }
    public String a;
    public String b;

    public Set<String> memo = new HashSet<>();

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(String a, String b) {
        boolean check = dfs(a, b);
        return check ? 1 : 0;
    }

    public boolean dfs(String a, String b) {
        if (a.length() == b.length()) {
            return a.equals(b);
        }

        char aa = b.charAt(b.length() - 1);
        char bb = b.charAt(0);

        // 뒷자리가 A인 경우
        if (aa == 'A') {
            if (dfs(a, b.substring(0, b.length() - 1))) {
                return true;
            }
        }

        // 앞자리가 B인 경우
        if (bb == 'B') {
            String newS = new StringBuilder(b.substring(1)).reverse().toString();
            if (dfs(a, newS)) {
                return true;
            }
        }

        return false;

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

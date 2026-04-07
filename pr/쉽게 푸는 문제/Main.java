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
        System.out.println(this.solve(n, m));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    int n;
    int m;
    int ans;

    List<Integer> chapter;

    public int solve(int n, int m) {
        this.n = n;
        this.m = m;
        this.chapter = new ArrayList<>();
        this.ans = 0;

        dfs(1, 0);

        for (int i = n - 1; i < chapter.size(); i++) {
            ans += chapter.get(i);
        }

        return ans;
    }

    void dfs(int num, int index) {
        if (index == m) {
            return;
        }

        chapter.add(num);

        if (chapter.stream().filter(c -> c == num).count() == num) {
            dfs(num + 1, index + 1);
        } else {
            dfs(num, index + 1);
        }

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

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
        arr[i][0] = fr.next();
        arr[i][1] = fr.next();
        }
        System.out.println(this.solve(n, arr));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public String solve(int n, String[][] arr) {
        int[] count = new int[120005];
        for (String[] s : arr) {
            int start = toIndex(s[0]);
            int end = toIndex(s[1]);
            count[start]++;
            count[end + 1]--;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int max = -1;
        String result = "";
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                result = toTime(i);
            }
        }

        return result;
    }

    private int toIndex(String time) {
        String[] parts = time.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        return (year * 12) + month;
    }

    private String toTime(int index) {
        int year = index / 12;
        int month = index % 12;
        if (month == 0) {
            month = 12;
            year--;
        }
        return String.format("%04d-%02d", year, month);
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

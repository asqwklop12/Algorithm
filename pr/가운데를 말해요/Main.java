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
        int[] res = this.solve(n, arr);
        StringBuilder _sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {{
        _sb.append(res[i]).append(" ");
        }}
        System.out.println(_sb.toString().trim());
    }
    /**
     * 문제 해결 메서드
     * 
     * @param n   백준이가 외치는 정수의 개수
     * @param arr 백준이가 외치는 정수 배열
     * @return 중간값들을 담은 배열
     */
    public int[] solve(int n, int[] arr) {

        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (list.get(mid) < num) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            list.add(low, num);

            int mid = list.get((list.size() - 1) / 2);
            answer[i] = mid;
        }

        return answer;
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

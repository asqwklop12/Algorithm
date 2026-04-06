import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        long g = Long.parseLong(fr.next());
        int k = Integer.parseInt(fr.next());
        long[][] ingredients = new long[n][3];
        for (int i = 0; i < n; i++) {
        ingredients[i][0] = Long.parseLong(fr.next()); // S
        ingredients[i][1] = Long.parseLong(fr.next()); // L
        ingredients[i][2] = Long.parseLong(fr.next()); // O
        }
        System.out.println(this.solve(n, g, k, ingredients));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param n           재료의 개수
     * @param g           세균 수 상한
     * @param k           뺄 수 있는 재료의 최대 개수
     * @param ingredients 각 재료의 정보 [S, L, O]
     * @return 가능한 최대 일수
     */

    public int n;
    public long g;
    public int k;
    public long[][] ingredients;

    public long solve(int n, long g, int k, long[][] ingredients) {
        this.g = g;
        this.n = n;
        this.k = k;
        this.ingredients = ingredients;
        long low = 0;
        // high는 충분히 큰 값으로 설정 (20억 일 이상)
        long high = 2000000000L;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(mid)) {
                ans = mid; // 가능하면 더 큰 날짜를 찾아봄
                low = mid + 1;
            } else {
                high = mid - 1; // 불가능하면 날짜를 줄임
            }
        }
        return ans;
    }

    private boolean check(long days) {
        long totalBacteria = 0;
        long[] removable = new long[n]; // 삭제 가능 재료들의 세균량을 담을 배열
        int removableCount = 0;
        for (long[] ingredient : ingredients) {
            long s = ingredient[0];
            long l = ingredient[1];
            long o = ingredient[2];

            // 세균 산출 공식: S * max(1, days - L)
            long bacteria = s * Math.max(1, days - l);

            if (o == 1) {
                // 삭제 가능한 재료는 리스트에 따로 보관
                removable[removableCount++] = bacteria;
            } else {
                // 삭제 불가능한 필수 재료는 바로 합산
                totalBacteria += bacteria;
                // [꿀팁] 중간에 이미 G를 넘으면 더 볼 것도 없이 false (오버플로우 방지)
                if (totalBacteria > g)
                    return false;
            }
        }
        // 삭제 가능한 재료들의 세균량을 오름차순으로 정렬
        Arrays.sort(removable, 0, removableCount);

        // 가장 큰 세균량을 가진 상위 K개를 제외하고 나머지만 합산
        // 즉, 전체 삭제 가능 개수에서 K개를 뺀 만큼(작은 쪽부터) 더함
        int limit = Math.max(0, removableCount - k);
        for (int i = 0; i < limit; i++) {
            totalBacteria += removable[i];
            if (totalBacteria > g)
                return false;
        }
        return totalBacteria <= g;
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

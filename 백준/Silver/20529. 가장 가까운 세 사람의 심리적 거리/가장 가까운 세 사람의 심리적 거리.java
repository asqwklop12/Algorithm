import java.io.*;
import java.util.*;

public class Main {

    // 입력에 등장한 MBTI만 저장
    static Map<String, Integer> indexMap;
    static String[] usedMbti;
    static int[] count;
    static int idx;

    static int min;
    static List<Integer> pick;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] friends = new String[N];
            for (int i = 0; i < N; i++) {
                friends[i] = st.nextToken();
            }

            sb.append(solve(friends)).append('\n');
        }

        System.out.print(sb.toString());
    }

    public static int solve(String[] friends) {

        // ===== 초기화 =====
        indexMap = new HashMap<>();
        usedMbti = new String[16];
        count = new int[16];
        pick = new ArrayList<>();
        idx = 0;
        min = Integer.MAX_VALUE;
        // ==================

        // MBTI 상태 압축
        for (String mbti : friends) {
            if (!indexMap.containsKey(mbti)) {
                indexMap.put(mbti, idx);
                usedMbti[idx] = mbti;
                idx++;
            }
            count[indexMap.get(mbti)]++;
        }

        // 중복 조합 DFS
        dfs(0, 0);

        return min;
    }

    static void dfs(int start, int depth) {

        // 가지치기: 최소는 0
        if (min == 0)
            return;

        if (depth == 3) {
            int a = pick.get(0);
            int b = pick.get(1);
            int c = pick.get(2);

            // 필요한 인원 수 체크
            int[] need = new int[16];
            need[a]++;
            need[b]++;
            need[c]++;

            for (int i = 0; i < idx; i++) {
                if (need[i] > count[i])
                    return; // 불가능한 조합
            }

            String s1 = usedMbti[a];
            String s2 = usedMbti[b];
            String s3 = usedMbti[c];

            int dist = distance(s1, s2) +
                    distance(s1, s3) +
                    distance(s2, s3);

            min = Math.min(min, dist);
            return;
        }

        for (int i = start; i < idx; i++) {
            pick.add(i);
            dfs(i, depth + 1);
            pick.remove(pick.size() - 1);
        }
    }

    static int distance(String a, String b) {
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i))
                d++;
        }
        return d;
    }
}
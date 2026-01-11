import java.util.*;

public class Main {

    static int n;
    static String[] words;
    static List<Character> letters = new ArrayList<>();
    static boolean[] used = new boolean[10]; // 숫자 사용 여부
    static int[] mapping = new int[26]; // 알파벳 → 숫자
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
            for (char c : words[i].toCharArray()) {
                if (!letters.contains(c)) {
                    letters.add(c);
                }
            }
        }

        dfs(0);
        System.out.println(max);
    }

    // level번째 알파벳에 숫자를 배정
    static void dfs(int level) {
        // 모든 알파벳에 숫자 배정 완료
        if (level == letters.size()) {
            int sum = 0;

            // 단어들을 숫자로 변환해 합 계산
            for (String word : words) {
                int value = 0;
                for (char c : word.toCharArray()) {
                    value = value * 10 + mapping[c - 'A'];
                }
                sum += value;
            }

            max = Math.max(max, sum);
            return;
        }

        // 숫자 0~9 중 아직 안 쓴 것 선택
        for (int num = 0; num <= 9; num++) {
            if (used[num])
                continue;

            used[num] = true;
            mapping[letters.get(level) - 'A'] = num;

            dfs(level + 1);

            used[num] = false; // 백트래킹
        }
    }
}

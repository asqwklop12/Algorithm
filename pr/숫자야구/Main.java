import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N;
    static int[][] hints;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        hints = new int[N][3];

        for (int i = 0; i < N; i++) {
            hints[i][0] = sc.nextInt(); // Number
            hints[i][1] = sc.nextInt(); // Strike
            hints[i][2] = sc.nextInt(); // Ball
        }

        solve();
        System.out.println(ans);
    }

    public static void solve() {

        action(new int[3], new boolean[10], 0);
    }

    public static void action(int[] numbers, boolean[] visted, int depth) {
        if (depth == 3) {
            baseball(numbers);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!visted[i]) {
                visted[i] = true;
                numbers[depth] = i;
                action(numbers, visted, depth + 1);
                visted[i] = false;
            }
        }
    }

    public static void baseball(int[] answer_digits) {
        for (int i = 0; i < N; i++) {
            int num = hints[i][0];

            int[] num_digits = { num / 100, (num / 10) % 10, num % 10 };
            int strike = 0;
            int ball = 0;
            Set<Integer> answerSet = Set.of(answer_digits[0], answer_digits[1], answer_digits[2]);

            for (int j = 0; j < 3; j++) {
                if (answer_digits[j] == num_digits[j]) {
                    strike++;
                } else if (answerSet.contains(num_digits[j])) {
                    ball++;
                }
            }

            if (strike != hints[i][1] || ball != hints[i][2]) {
                return;
            }
        }
        ans++;
    }
}

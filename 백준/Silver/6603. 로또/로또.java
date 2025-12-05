import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            List<Integer> list = new ArrayList<>();
            int[] result = new int[6];
            if (sc.hasNextInt()) {
                int N = sc.nextInt();

                if (N == 0) {
                    return;
                }

                for (int i = 0; i < N; i++) {
                    list.add(sc.nextInt());
                }
                go(list, result);
            }
            System.out.println();
        }

    }

    public static void go(List<Integer> list, int[] result) {
        combination(list, result, 0, 0);
    }

    public static void combination(List<Integer> list, int[] result, int start, int next) {
        if (next == 6) {

            for (int i = 0; i < 6; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            result[next] = list.get(i);
            combination(list, result, i + 1, next + 1);
        }
    }
}

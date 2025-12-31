import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;

    static int[] arr;

    static boolean[] visited;

    static List<Integer> path = new ArrayList<>();

    static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solve();

    }

    public static void solve() {
        backtrack();

        System.out.println(answer.size());
    }

    static void backtrack() {
        // K개를 뽑았으면 출력
        if (path.size() == K) {

            String temp = "";
            for (int n : path) {
                temp += n;
            }
            answer.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            // 1️⃣ 선택
            visited[i] = true;
            path.add(arr[i]);

            // 2️⃣ 재귀
            backtrack();

            // 3️⃣ 원상 복구
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

}

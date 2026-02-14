import java.util.*;

public class Main {
    static int n;
    static int k;
    static String[] words;
    static boolean[] visited = new boolean[26];

    static int answer = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        words = new String[n];

        String start = "anta";
        String end = "tica";
        for (int i = 0; i < 4; i++) {
            visited[start.charAt(i) - 'a'] = true;
            visited[end.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        solve();

    }

    public static void solve() {
        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    static void dfs(int idx, int count) {

        if (count == k - 5) {
            int countWord = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a'])
                        break;
                    if (j == words[i].length() - 1)
                        countWord++;
                }
            }
            answer = Math.max(answer, countWord);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] maps; // 입력받을 맵
    static int n; // 크기
    static int m; // 크기

    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 크기 입력
        m = Integer.parseInt(st.nextToken()); // 크기 입력
        visited = new boolean[n];

        maps = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 시작점
            int y = Integer.parseInt(st.nextToken()); // 종료점
            maps[x - 1].add(y - 1);
            maps[y - 1].add(x - 1);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);


    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int i : maps[start]) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }


}

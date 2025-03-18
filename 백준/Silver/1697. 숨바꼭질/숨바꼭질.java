import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int n;
    static int m;


    static boolean[] visited = new boolean[200000];
    static int[] dist = new int[200000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimensions = br.readLine().split(" ");
        n = Integer.parseInt(dimensions[0]);
        m = Integer.parseInt(dimensions[1]);

        // 이동하지 않는 다는걸 저장한다.

        // 최초 이동은 1로 지정한다.
        // 큐에 데이터를 넣고
        q.add(n);

        bfs();


        System.out.println(dist[m]);
    }

    private static void bfs() {
        // 더하기 더하기 곱셈
        while (!q.isEmpty()) {
            Integer c = q.poll();
            visited[c] = true;
            int[] nx = {c - 1, c + 1, c * 2};

            for (int i = 0; i < nx.length; i++) {
                if (nx[i] < 0 || 200000 <= nx[i]) {
                    continue;
                }
                if (visited[nx[i]]) continue;
                q.add(nx[i]);
                visited[nx[i]] = true;
                dist[nx[i]] = dist[c] + 1;

            }
        }

    }

}
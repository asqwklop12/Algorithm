import java.io.*;
import java.util.*;


public class Main {


    static int[] dist = new int[2000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 초기화
        Arrays.fill(dist, -1);

        q.add(S);
        dist[S] = 0;
        while (!q.isEmpty()) {
            Integer x = q.poll();

            if (x == G) {
                System.out.println(dist[G]);
                return;
            }
            int[] move = {x + U, x - D};
            // 이동
            for (int mx : move) {
                if (mx <= F && mx >= 1 && dist[mx] == -1) {
                    q.add(mx);
                    dist[mx] = dist[x] + 1;

                }

            }

        }

        System.out.println("use the stairs");
    }


}
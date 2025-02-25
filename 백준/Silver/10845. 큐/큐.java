import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        while (N-- > 0) {
            String cmd = br.readLine();
            String[] point = cmd.split(" ");

            String action = point[0];

            if (action.equals("push")) {
                int input = Integer.parseInt(point[1]);
                last = input;
                q.add(input);
            }

            if (action.equals("front")) {
                if (!q.isEmpty()) {
                    System.out.println(q.peek());
                } else {
                    System.out.println(-1);
                }
            }

            if (action.equals("pop")) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                    if (q.isEmpty()) {
                        last = -1;
                    }
                } else {
                    System.out.println(-1);
                }
            }

            if (action.equals("back")) {
                System.out.println(last);
            }

            if (action.equals("size")) {
                System.out.println(q.size());
            }

            if (action.equals("empty")) {
                System.out.println(q.isEmpty() ? 1 : 0);
            }

        }

        bw.flush();
        bw.close();
    }

}
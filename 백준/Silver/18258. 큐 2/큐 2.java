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
                    bw.write(q.peek() + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            }

            if (action.equals("pop")) {
                if (!q.isEmpty()) {
                    bw.write(q.poll()+"\n");
                    if (q.isEmpty()) {
                        last = -1;
                    }
                } else {
                    bw.write("-1\n");
                }
            }

            if (action.equals("back")) {
                bw.write(last + "\n");
            }

            if (action.equals("size")) {
                bw.write(q.size() + "\n");
            }

            if (action.equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }

        }

        bw.flush();
        bw.close();
    }

}
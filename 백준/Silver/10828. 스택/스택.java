import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            String cmd = br.readLine();
            String[] point = cmd.split(" ");

            String action = point[0];

            if (action.equals("push")) {
                int input = Integer.parseInt(point[1]);
                stack.push(input);
            }


            if (action.equals("pop")) {
                if (!stack.isEmpty()) {
                    bw.write(stack.pop() + "\n");
                } else {
                    bw.write("-1\n");
                }
            }

            if (action.equals("top")) {
                if (!stack.isEmpty()) {
                    bw.write(stack.peek() + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            }

            if (action.equals("size")) {
                bw.write(stack.size() + "\n");
            }

            if (action.equals("empty")) {
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            }

        }

        bw.flush();
        bw.close();
    }

}
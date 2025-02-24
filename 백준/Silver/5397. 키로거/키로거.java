import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());


        while (M-- > 0) {
            String str = br.readLine();
            System.out.println(go(str));


        }


        bw.flush();
        bw.close();
    }

    private static String go(String input) {
        List<Character> list = new LinkedList<>();
        ListIterator<Character> cursor = list.listIterator();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case '>':
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case '-':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                default:
                    cursor.add(c);
                    break;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
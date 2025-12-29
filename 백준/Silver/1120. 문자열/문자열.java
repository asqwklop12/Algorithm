import java.io.*;

public class Main {

    static String A;
    static String B;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        A = inputs[0];
        B = inputs[1];

        solve();

        System.out.println(result);

    }

    public static void solve() {
        for (int i = 0; i < B.length(); i++) {
            int alength = A.length();

            if (alength + i > B.length())
                break;

            String subB = subString(i, i + alength - 1);
            result = Math.min(result, convert(A, subB));

            if (result == 0)
                break;
        }

    }

    public static String subString(int start, int end) {
        return B.substring(start, end + 1);
    }

    public static int convert(String A, String B) {
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                count++;
        }

        return count;
    }
}
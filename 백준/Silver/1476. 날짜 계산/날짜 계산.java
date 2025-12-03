
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int e = Integer.parseInt(token.nextToken());
    int s = Integer.parseInt(token.nextToken());
    int m = Integer.parseInt(token.nextToken());

    System.out.println(go(1, 1, 1, 1, e, s, m));
  }

  private static int go(int a, int b, int c, int result, int e, int s, int m) {
    if (a == e && b == s && c == m) {
      return result;
    }
    if (a == 15) {
      a = 1;
    } else {
      a = a + 1;
    }

    if (b == 28) {
      b = 1;
    } else {
      b++;
    }

    if (c == 19) {
      c = 1;
    } else {
      c++;
    }
    return go(a, b, c, result + 1, e, s, m);
  }
}

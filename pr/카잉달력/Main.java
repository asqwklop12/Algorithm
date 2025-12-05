import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(br.readLine());

    while (tc-- > 0) {
      StringTokenizer token = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(token.nextToken());
      int N = Integer.parseInt(token.nextToken());
      int x = Integer.parseInt(token.nextToken());
      int y = Integer.parseInt(token.nextToken());
      boolean check = true;
      x--;
      y--;
      for (int i = x; i < (N*M); i+=M) {
        if (i % N == y) {
          System.out.println(i+1);
          check = false;
          break;
        }
      }
      if (check) {
        System.out.println(-1);
      }

    }
  }
}

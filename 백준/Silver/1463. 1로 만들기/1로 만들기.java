import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] maps = new int[n + 10];

    maps[1] = 0;

    for (int i = 2; i <= n; i++) {
      maps[i] = maps[i - 1] + 1;

      if (i % 2 == 0) {
        maps[i] = Math.min(maps[i], maps[i / 2] + 1);
      }

      if (i % 3 == 0) {
        maps[i] = Math.min(maps[i], maps[i / 3] + 1);
      }
    }

    System.out.println(maps[n]);


  }
}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] dwarfs = new int[9];
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      dwarfs[i] = Integer.parseInt(br.readLine());
      sum += dwarfs[i];
    }
    int[] not = new int[2];
    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - (dwarfs[i] + dwarfs[j]) == 100) {
          not[0] = dwarfs[i];
          not[1] = dwarfs[j];
        }
      }
    }
    Arrays.sort(dwarfs);
    for (int i = 0; i < 9; i++) {
      if(dwarfs[i] == not[0] || dwarfs[i] == not[1]) {
        continue;
      }
      bw.write(dwarfs[i]+"\n");
    }
    bw.flush();
    bw.close();
  }
}

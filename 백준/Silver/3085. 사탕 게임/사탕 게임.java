
import java.util.Scanner;

public class Main {
  static int check(char[][] a) {
    int n = a.length;
    int ans = 1;
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 1; j < n; j++) {
        if (a[i][j] == a[i][j - 1]) {
          cnt += 1;
        } else {
          cnt = 1;
        }
        ans = Math.max(ans,cnt);
      }
      cnt = 1;
      for (int j = 1; j < n; j++) {
        if (a[j][i] == a[j - 1][i]) {
          cnt += 1;
        } else {
          cnt = 1;
        }
        ans = Math.max(ans,cnt);
        
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    char[][] a = new char[n][n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.next().toCharArray();
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j + 1 < n) {
          char t = a[i][j];
          a[i][j] = a[i][j + 1];
          a[i][j + 1] = t;
          ans = Math.max(ans,check(a));
          t = a[i][j];
          a[i][j] = a[i][j + 1];
          a[i][j + 1] = t;
        }
        if (i + 1 < n) {
          char t = a[i][j];
          a[i][j] = a[i + 1][j];
          a[i + 1][j] = t;
          ans = Math.max(ans,check(a));
          t = a[i][j];
          a[i][j] = a[i + 1][j];
          a[i + 1][j] = t;
        }
      }
    }
    System.out.println(ans);
  }
}
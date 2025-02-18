import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];

        d[1] = 0;  // 1은 연산이 필요 없음
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;  // 기본 연산 (1 빼기)
            
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
        }

        System.out.println(d[n]);
    }
}
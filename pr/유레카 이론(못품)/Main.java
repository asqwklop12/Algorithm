import java.util.*;

public class Main {

    static int[] triangularNumbers;
    static int tCount;

    public static void main(String[] args) {
        precomputeTriangularNumbers();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    public static void precomputeTriangularNumbers() {
        triangularNumbers = new int[50]; // Sufficient for K <= 1000
        int n = 1;
        tCount = 0;
        while (true) {
            int val = n * (n + 1) / 2;
            if (val > 1000)
                break;
            triangularNumbers[tCount++] = val;
            n++;
        }
    }

    public static int solve(int k) {
        for (int i = 0; i < tCount; i++) {
            for (int j = 0; j < tCount; j++) {
                for (int m = 0; m < tCount; m++) {
                    if (triangularNumbers[i] + triangularNumbers[j] + triangularNumbers[m] == k) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

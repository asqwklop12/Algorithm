import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = solve(str);
        System.out.println(result);
    }

    public static int solve(String str) {
        int temp = 0;
        int tempIndx = 0;
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '*') {
                tempIndx = i; // 0 ~ 9까지
                continue;
            }

            int num = x - '0';
            // 짝수일때
            if (i % 2 == 0) {
                temp += (num * 1);
            }

            // 홀수 일때
            if (i % 2 != 0) {
                temp += (num * 3);
            }
        }

        return action(temp, tempIndx);
    }

    public static int action(int temp, int tempIndx) {
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            int num = 0;
            if (tempIndx % 2 == 0) {
                num = temp + (i * 1);
            }
            if (tempIndx % 2 != 0) {
                num = temp + (i * 3);
            }

            if (num % 10 == 0) {
                result = i;
                break;
            }

        }
        return result;
    }

}

import java.util.*;
public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        solve();

    }

    public static void solve() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += check(i);
        }
        System.out.println(count);
    }

    public static int check(int num) {
        String str = String.valueOf(num);
        // 100자리 이하인 수들은 전부 등차 수열에 만족한다.
        if (str.length() < 3) {
            return 1;
        }

        // 첫번째와 두번째의 차이를 구한다.
        int diff = str.charAt(0) - str.charAt(1);
        for (int i = 1; i < str.length() - 1; i++) {
            int curDiff = str.charAt(i) - str.charAt(i + 1);
            // 현재 차이와 이전 차이가 다르면 0 리턴
            if (curDiff != diff) {
                return 0;
            }
            diff = curDiff;
        }

        return 1;
    }

}
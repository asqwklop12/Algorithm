public class Main {
    static boolean[] visit = new boolean[10001];

    public static void main(String[] args) {

        solve();

        for (int i = 1; i <= 10000; i++) {
            if (!visit[i]) {
                System.out.println(i);
            }
        }
    }

    public static void solve() {
        for (int i = 1; i <= 10000; i++) {
            int n = i;
            int result = 0;
            while (n > 0) {
                result += (n % 10);
                n /= 10;
            }
            result += i;
            if (result <= 10000) {
                visit[result] = true;
            }

        }

    }

}

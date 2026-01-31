import java.io.*;
import java.util.*;

class Poll {
    int L;
    int H;

    Poll(int L, int H) {
        this.L = L;
        this.H = H;
    }
}

public class Main {
    static int n;
    static Poll[] polls;
    static Poll standPoll;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        polls = new Poll[n];
        int maxH = -1;
        for (int i = 0; i < n; i++) {
            polls[i] = new Poll(sc.nextInt(), sc.nextInt());
            if (maxH < polls[i].H) {
                maxH = polls[i].H;
                standPoll = polls[i];
            }
        }
        Arrays.sort(polls, (o1, o2) -> o1.L - o2.L);
        solve();

    }

    public static void solve() {

        int currentH = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (polls[i] == standPoll)
                break;
            currentH = Math.max(currentH, polls[i].H);
            total += (polls[i + 1].L - polls[i].L) * currentH;
        }

        currentH = 0;
        for (int i = n - 1; i > 0; i--) {
            if (polls[i] == standPoll)
                break;
            currentH = Math.max(currentH, polls[i].H);
            total += (polls[i].L - polls[i - 1].L) * currentH;
        }

        total += standPoll.H;
        System.out.println(total);

    }

}
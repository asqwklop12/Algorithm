import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);

    }

    // 666 ->
    // 1,2,3,4,5,6,7,8,9..............................
    // 666,667 ......................................
    // 1666

    // 1666 -> 2666 -> 3666 -> 4666 -> 5666 -> 6660 -> 6661 -> 6662
    // -> 6663 -> 6664 -> 6665 -> 6666 -> 6667 -> 6668 -> 6669 -> 6669
    // -> 16660 -> 16661 -> 16662 -> 16663 -> 16664 -> 16665 -> 16666
    // -> 16667 -> 16668 -> 16669 -> 26660 -> 26661 -> 26662 -> 26663
    // -> 26664 -> 26665 -> 26666 -> 26667 -> 26668 -> 26669 -> 36660

    public static void solve(int n) {
        System.out.println(dfs(n, 1, 666));
    }

    public static int dfs(int n, int count, int num) {
        if (count == n) {
            return num;
        }

        num++;
        if (String.valueOf(num).contains("666")) {
            count++;
        }

        return dfs(n, count, num);

    }

}
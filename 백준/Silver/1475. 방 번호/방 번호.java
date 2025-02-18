import java.util.*;

public class Main {

    static int[] arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] chars = String.valueOf(n).toCharArray();

        for (char ch : chars) {
            arr[ch - '0']++;
        }


        int six = arr[6];
        int nine = arr[9];
        int min = 0;

        int sixOrNine = Math.min(six, nine);
        int abs = Math.abs(six - nine);
        int subst = (abs / 2) + (abs % 2);

        int rsn = sixOrNine + subst;

        for (int i = 0; i < arr.length; i++) {
            if (i == 6 || i == 9) continue;
            int result = arr[i];
            min = Math.max(min, result);
        }

        System.out.println(Math.max(min, rsn));
    }


}